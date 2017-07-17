package com.alipay.lyf.rxjavasample.net.service;

import com.alipay.lyf.rxjavasample.entity.PageListEntity;
import com.alipay.lyf.rxjavasample.net.bean.ResponseInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 01F on 2017/6/10.
 */

public interface PlanService {
    String url = "iext/mobile/gup/";
    @GET(url+"personal/list.do")
    Observable<ResponseInfo<PageListEntity>> getPlanList(@Query("type")Integer type, @Query("pageNum")Integer pageNum);

}
