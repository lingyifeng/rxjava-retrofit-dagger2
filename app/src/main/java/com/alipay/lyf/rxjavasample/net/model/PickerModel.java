package com.alipay.lyf.rxjavasample.net.model;

import com.alipay.lyf.rxjavasample.net.bean.ResponseInfo;
import com.alipay.lyf.rxjavasample.net.service.PickerService;
import com.google.gson.JsonObject;

import rx.Observable;

/**
 * Created by 01F on 2017/7/11.
 */

public class PickerModel {

    private PickerService mService;

    public PickerModel(PickerService service) {
        mService = service;
    }
    public Observable<ResponseInfo<JsonObject>> getPickerInfo(){
       return mService.getPickerInfo();
    }
    public  Observable<ResponseInfo<JsonObject>> getChooseList(Integer[] cateids,Integer viptype,
                                                               Integer sort,Integer status,
                                                               int pageNum,String text){
        return mService.getChooseList(cateids,viptype,sort,status,pageNum,text);
    }
}
