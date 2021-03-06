package com.alipay.lyf.rxjavasample.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiang.common.base.CommonFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by jiang on 2017/2/28.
 */

public abstract class MVPBaseFragment<T extends BasePresenter> extends CommonFragment {
    @Inject
    public T mPresenter;

    protected Context mContext;

    Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (rootView == null)
            rootView = inflater.inflate(getLayoutId(), container, false);
        if (unbinder == null)
            unbinder = ButterKnife.bind(this, rootView);
        init(rootView);
        initInjector();
        return rootView;
    }

    @Override
    public void onDestroyView() {
        mPresenter = null;
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroyView();
    }

    /*********************
     * 子类实现
     *****************************/
    //获取布局文件
    public abstract int getLayoutId();

    //初始化view
    protected abstract void init(View view);

    // dagger 注入
    protected abstract void initInjector();



    public T getPresenter() {
        return mPresenter;
    }
}
