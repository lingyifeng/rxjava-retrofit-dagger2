package com.alipay.lyf.rxjavasample.ui.presenter;

import android.os.Environment;
import android.support.annotation.NonNull;

import com.alipay.lyf.rxjavasample.base.BasePresenter;
import com.alipay.lyf.rxjavasample.encrypt.MediaEncrypt;
import com.alipay.lyf.rxjavasample.entity.PageEntity;
import com.alipay.lyf.rxjavasample.entity.PageListEntity;
import com.alipay.lyf.rxjavasample.entity.PlanDetailEntity;
import com.alipay.lyf.rxjavasample.helper.recyclerview.BaseRecyclerAdapter;
import com.alipay.lyf.rxjavasample.helper.recyclerview.PageListHelper;
import com.alipay.lyf.rxjavasample.helper.recyclerview.PageListListener;
import com.alipay.lyf.rxjavasample.net.api.RetrofitCallback;
import com.alipay.lyf.rxjavasample.net.model.DownLoadModel;
import com.alipay.lyf.rxjavasample.net.model.MainModel;
import com.alipay.lyf.rxjavasample.rx.HttpUtil;
import com.alipay.lyf.rxjavasample.rx.RxDataSubscriber;
import com.alipay.lyf.rxjavasample.ui.MainActivity;
import com.jiang.common.base.irecyclerview.IRecyclerView;
import com.jiang.common.utils.LogUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by 01F on 2017/6/10.
 */

public class MainPresenter extends BasePresenter {

    private PageListHelper mHelper;
    private MainActivity mView;
    private MainModel mMainModel;

    private IRecyclerView mIRecyclerView;
    PageListListener mListener = pageNum -> getPlan(1, pageNum);

    @Inject
    public MainPresenter(IRecyclerView iRecyclerView, PageListHelper helper, MainActivity view, MainModel model) {
        mHelper = helper;
        mIRecyclerView = iRecyclerView;
        mView = view;
        mMainModel = model;
        mHelper.setPageListListener(mListener);
//        login();
//        mIRecyclerView.setRefreshing(true);
//        downLoad("/nPZyUPER_3485993_sd.mp4?download=%E6%B5%81%E7%95%85_%E7%AE%A1%E7%90%86%E5%91%98%E5%A1%AB%E5%86%99%E4%BC%81%E4%B8%9A%E4%BF%A1%E6%81%AF.mp4.mp4");
//        downLoad("vodwbil74qz.nosdn.127.net/nPZyUPER_3485993_sd.mp4?download=%E6%B5%81%E7%95%85_%E7%AE%A1%E7%90%86%E5%91%98%E5%A1%AB%E5%86%99%E4%BC%81%E4%B8%9A%E4%BF%A1%E6%81%AF.mp4.mp4&wsiphost=local");
    }

    public void login() {
        HttpUtil.getInstance().loadDatasForMsg(mMainModel.login(),
                new RxDataSubscriber<String>(mView) {
                    @Override
                    protected void _onNext(String s) {
                        mView.showLongToast(s);
                    }

                    @Override
                    protected void _onError(String message) {
                        mView.showLongToast(message);
                    }
                });
    }

    public void downLoad(String url) {
        int i = url.lastIndexOf("/");
        String filepath =
                Environment.getExternalStorageDirectory() + "/Download/" + "haha" + ".mp4";
        RetrofitCallback<ResponseBody> callback = getCallback(filepath);
        DownLoadModel.getInstance().getRetrofitService(callback).download(url).enqueue(callback);
    }

    @NonNull
    public RetrofitCallback<ResponseBody> getCallback(final String filepath) {
        return new RetrofitCallback<ResponseBody>() {
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                super.onFailure(call, t);
//                mView.downOnErr();
                LogUtils.loge("下载失败"+t.getMessage());
            }

            @Override
            public void onLoading(long total, long progress) {
                super.onLoading(total, progress);
                LogUtils.loge("total:  " + total + "   " + (int) (progress * 100 / total));
                int i = (int) (progress * 100 / total);
//                if (mView.proLoading.getProgress() != i) {
                if (mView.proLoading != null) {
                    mView.proLoading.setProgress(i);
                }
//                }


                LogUtils.loge((int) (progress / total * 100)+"");
            }

            @Override
            public void onSuccess(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    LogUtils.loge("开始下载");
                    InputStream is = response.body().byteStream();
                    File file = new File(filepath);
                    FileOutputStream fos = new FileOutputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(is);
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = bis.read(buffer)) != -1) {
                        fos.write(buffer, 0, len);
                    }
                    fos.flush();
                    fos.close();
                    bis.close();
                    is.close();
//                    mView.downloadFinished();
                    LogUtils.loge("下载完成");
                    LogUtils.loge("length  " + file.length());
                    MediaEncrypt.encrypt(file.getAbsolutePath());
                } catch (IOException e) {
                    e.printStackTrace();
                    LogUtils.loge(e.toString());
                }
            }
        };
    }

    public void getPlan(int type, final int pagenum) {
        HttpUtil.getInstance().loadDatasForBody(mMainModel.getPlanList(type, pagenum),
                new RxDataSubscriber<PageListEntity>(mView) {
                    @Override
                    protected void _onNext(PageListEntity pageListEntity) {
                        PageEntity<PlanDetailEntity> pagelist = pageListEntity.getPagelist();
                        mHelper.setPageBean(pagelist);
                        mHelper.stopLoading();
                        if (mHelper.isRefresh()) {
                            BaseRecyclerAdapter adapter = (BaseRecyclerAdapter) mIRecyclerView.getIAdapter();
                            adapter.clear();
                        }

                        mView.mPlanAdapter.addList(pagelist.getResult());
                    }

                    @Override
                    protected void _onError(String message) {
                        mHelper.stopLoading();
                        mView.showLongToast(message);
                    }
                });
    }
}
