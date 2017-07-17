package com.alipay.lyf.rxjavasample.inject.components;

import com.alipay.lyf.rxjavasample.inject.modules.PickerModule;
import com.alipay.lyf.rxjavasample.ui.PickerActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by 01F on 2017/7/12.
 */
@Singleton
@Component(modules = PickerModule.class)
public interface PickerComponent {
    void inject(PickerActivity activity);
}
