package com.alipay.lyf.rxjavasample.inject.modules;

import com.alipay.lyf.rxjavasample.net.api.Api;
import com.alipay.lyf.rxjavasample.net.model.PickerModel;
import com.alipay.lyf.rxjavasample.net.service.PickerService;
import com.alipay.lyf.rxjavasample.ui.PickerActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 01F on 2017/7/12.
 */
@Module
public class PickerModule {

    private PickerActivity mView;

    public PickerModule(PickerActivity view) {
        mView = view;
    }
    @Singleton
    @Provides
    public PickerActivity provideView(){
        return mView;
    }
    @Singleton
    @Provides
    public PickerService provideService(){
        return Api.getInstance(PickerService.class);
    }
    @Singleton
    @Provides
    public PickerModel provideModel(PickerService service){
        return new PickerModel(service);
    }

}
