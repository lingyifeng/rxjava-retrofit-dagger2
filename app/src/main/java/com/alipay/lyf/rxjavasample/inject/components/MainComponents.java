package com.alipay.lyf.rxjavasample.inject.components;

import com.alipay.lyf.rxjavasample.inject.modules.MainModules;
import com.alipay.lyf.rxjavasample.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by 01F on 2017/6/10.
 */
@Singleton
@Component(modules = MainModules.class)
public interface MainComponents {
    void inject(MainActivity activity);
}
