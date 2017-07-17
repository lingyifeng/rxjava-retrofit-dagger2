package com.alipay.lyf.rxjavasample.inject.modules;

import android.content.Context;

import com.alipay.lyf.rxjavasample.app.BaseApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 01F on 2017/6/10.
 */
@Module
public class ContextModules {
    @Provides
    public Context provideContext(){
        return BaseApplication.getAppContext();
    }
}
