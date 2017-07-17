package com.alipay.lyf.rxjavasample.net.model;

import android.support.annotation.NonNull;

import com.alipay.lyf.rxjavasample.app.BaseApplication;
import com.alipay.lyf.rxjavasample.net.api.FileResponseBody;
import com.alipay.lyf.rxjavasample.net.api.RetrofitCallback;
import com.alipay.lyf.rxjavasample.net.service.DownLoadService;
import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.jiang.common.utils.NetWorkUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.alipay.lyf.rxjavasample.net.api.Api.CONNECT_TIME_OUT;
import static com.alipay.lyf.rxjavasample.net.api.Api.READ_TIME_OUT;

/**
 * Created by 01F on 2017/5/27.
 */

public class DownLoadModel {
    private static volatile DownLoadModel instance = null;
    private DownLoadModel(){}
    public static DownLoadModel getInstance(){
        if(instance==null){
            synchronized (DownLoadModel.class) {
                if (instance == null) {
                    instance=new DownLoadModel();
                }
            }

        }
        return instance;
    }
    private static final long CACHE_STALE_SEC = 60 * 60 * 24 * 2;

    public <T> DownLoadService getRetrofitService(final RetrofitCallback<T> callback) {
        OkHttpClient client = getOkHttpClient("http://115.231.22.27/").addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Response response = chain.proceed(chain.request());
                //将ResponseBody转换成我们需要的FileResponseBody
                return response.newBuilder().body(new FileResponseBody<T>(response.body(), callback)).build();
            }
        }).build();
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://112.17.27.139/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DownLoadService service = retrofit.create(DownLoadService.class);
        return service;
    }

    @NonNull
    private OkHttpClient.Builder getOkHttpClient(String url) {
        //开启Log
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //缓存
        File cacheFile = new File(BaseApplication.getAppContext().getCacheDir(), "cache");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb
        //增加头部信息
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request build = chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json;charset=UTF-8")
                        .addHeader("Accept-Charset", "UTF-8")
                        .build();
                return chain.proceed(build);
            }
        };

        //增加cookie持久化
        ClearableCookieJar cookieJar =
                new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(BaseApplication.getAppContext()));

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .cookieJar(cookieJar)
                .addInterceptor(mRewriteCacheControlInterceptor)
                .addNetworkInterceptor(mRewriteCacheControlInterceptor)
                .addInterceptor(logInterceptor)
                .retryOnConnectionFailure(true)
                .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .addInterceptor(headerInterceptor);

        if (url.equals("https://mobile.idaqi.com")) {//如果是domain  加入https相关
            okHttpClient.sslSocketFactory(getSSLContext("idaqi.cer"));
        }
        //如果baseurl为domain  则增加https验证
        return okHttpClient;
    }

    /**
     * 云端响应头拦截器，用来配置缓存策略
     * Dangerous interceptor that rewrites the server's cache-control header.
     */
    private final Interceptor mRewriteCacheControlInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!NetWorkUtils.isNetConnected(BaseApplication.getAppContext())) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response originalResponse = chain.proceed(request);
            if (NetWorkUtils.isNetConnected(BaseApplication.getAppContext())) {
                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
                String cacheControl = request.cacheControl().toString();
                return originalResponse.newBuilder()
                        .header("Cache-Control", cacheControl)
                        .removeHeader("Pragma")
                        .build();
            } else {
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + CACHE_STALE_SEC)
                        .removeHeader("Pragma")
                        .build();
            }
        }
    };

    public SSLSocketFactory getSSLContext(String path) {

        SSLContext sslContext = null;
        try {

            InputStream certificate = BaseApplication.getAppResources().getAssets().open(path);

            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            String certificateAlias = Integer.toString(0);
            keyStore.setCertificateEntry(certificateAlias, certificateFactory.generateCertificate(certificate));
            if (certificate != null)
                certificate.close();

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.
                    getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);

            sslContext = SSLContext.getInstance("TLS");

            sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sslContext.getSocketFactory();
    }
}
