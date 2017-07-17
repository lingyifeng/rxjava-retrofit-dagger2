package com.alipay.lyf.rxjavasample.net.service;

import com.alipay.lyf.rxjavasample.net.bean.ResponseInfo;
import com.google.gson.JsonObject;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 01F on 2017/7/11.
 */

public interface PickerService {
    @GET("/mobile/cw/CoursewareController/getCatagoryTree.do")
    Observable<ResponseInfo<JsonObject>> getPickerInfo();

    @GET("mobile/cw/CoursewareController/infoAll.do")
    Observable<ResponseInfo<JsonObject>> getChooseList(@Query("cateid") Integer[] cateids,
                                                       @Query("viptype") Integer viptype,
                                                       @Query("sort") Integer sort,
                                                       @Query("status") Integer status,
                                                       @Query("pageNum") int pageNum,
                                                       @Query("text") String text);
}
