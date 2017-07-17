package com.alipay.lyf.rxjavasample.inject.modules;

import com.alipay.lyf.rxjavasample.helper.recyclerview.PageListHelper;
import com.alipay.lyf.rxjavasample.net.api.Api;
import com.alipay.lyf.rxjavasample.net.model.MainModel;
import com.alipay.lyf.rxjavasample.net.service.LoginService;
import com.alipay.lyf.rxjavasample.net.service.PlanService;
import com.alipay.lyf.rxjavasample.ui.MainActivity;
import com.jiang.common.base.irecyclerview.IRecyclerView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 01F on 2017/6/10.
 */
@Module
public class MainModules {

    private MainActivity mView;
    private IRecyclerView mIRecyclerView;

    public MainModules(MainActivity view, IRecyclerView IRecyclerView) {
        mView = view;
        mIRecyclerView = IRecyclerView;
    }

    @Singleton
    @Provides
    public MainActivity provideView() {
        return mView;
    }

    @Singleton
    @Provides
    public IRecyclerView provideIRecycleVIew() {
        return mIRecyclerView;
    }

    @Singleton
    @Provides
    public PageListHelper providePageListHelper() {
        return new PageListHelper(mIRecyclerView);
    }

    @Singleton
    @Provides
    public LoginService provideLoginService() {
        return Api.getInstance(LoginService.class);
    }

    @Singleton
    @Provides
    public PlanService providePlanService() {
        return Api.getInstance(PlanService.class);
    }

    @Singleton
    @Provides
    public MainModel provideMainModel(LoginService loginService, PlanService planService) {
        return new MainModel(loginService, planService);
    }

}
