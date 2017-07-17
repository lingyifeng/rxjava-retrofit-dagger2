package com.alipay.lyf.rxjavasample.net.model;

import com.alipay.lyf.rxjavasample.entity.LoginEntity;
import com.alipay.lyf.rxjavasample.entity.PageListEntity;
import com.alipay.lyf.rxjavasample.net.bean.ResponseInfo;
import com.alipay.lyf.rxjavasample.net.service.LoginService;
import com.alipay.lyf.rxjavasample.net.service.PlanService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import rx.Observable;

/**
 * Created by 01F on 2017/6/10.
 */

public class MainModel {
    private LoginService mLoginService;
    private PlanService mPlanService;

    public MainModel(LoginService loginService, PlanService planService) {
        mLoginService = loginService;
        mPlanService = planService;
    }

    public Observable<ResponseInfo<LoginEntity>> login(){
        HashMap<String, String> map = new HashMap<>();
        map.put("account", "18840851363");
        map.put("password", "123456");
        map.put("pushregid", "1a0018970a95266c4d6");
        map.put("desc", getDesc());
        return mLoginService.login(map);
    }


    public Observable<ResponseInfo<PageListEntity>> getPlanList(int type, int pagenum){
        return mPlanService.getPlanList(type,pagenum);
    }


    public String getDesc() {
        String str = "";
        JSONObject mJSONObject = new JSONObject();
        try {
            mJSONObject.put("client", "android");
            str = mJSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return str;
    }
}
