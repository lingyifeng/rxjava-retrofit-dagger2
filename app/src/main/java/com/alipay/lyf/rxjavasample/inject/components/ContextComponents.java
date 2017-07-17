package com.alipay.lyf.rxjavasample.inject.components;

import android.content.Context;

import com.alipay.lyf.rxjavasample.inject.modules.ContextModules;

import dagger.Component;

/**
 * Created by 01F on 2017/6/10.
 */

@Component(modules = ContextModules.class)
public interface ContextComponents {
    Context inject();
}
