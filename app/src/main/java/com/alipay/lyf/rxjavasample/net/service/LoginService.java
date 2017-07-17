package com.alipay.lyf.rxjavasample.net.service;

import com.alipay.lyf.rxjavasample.entity.LoginEntity;
import com.alipay.lyf.rxjavasample.net.bean.ResponseInfo;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by 01F on 2017/6/10.
 */

public interface LoginService {

    @FormUrlEncoded
    @POST("iext/mobile/user/login.do")
    Observable<ResponseInfo<LoginEntity>> login(@FieldMap Map<String, String> map);

}
