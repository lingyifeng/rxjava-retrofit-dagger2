package com.alipay.lyf.rxjavasample.ui.presenter;

import com.alipay.lyf.rxjavasample.base.BasePresenter;
import com.alipay.lyf.rxjavasample.entity.CourseBean;
import com.alipay.lyf.rxjavasample.entity.CwCataBean;
import com.alipay.lyf.rxjavasample.entity.PageEntity;
import com.alipay.lyf.rxjavasample.net.model.PickerModel;
import com.alipay.lyf.rxjavasample.rx.RxDataSubscriber;
import com.alipay.lyf.rxjavasample.rx.RxHelper;
import com.alipay.lyf.rxjavasample.ui.PickerActivity;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.jiang.common.utils.LogUtils;
import com.jiang.common.utils.ToastUtil;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by 01F on 2017/7/12.
 */

public class PickerPresenter extends BasePresenter {

    private PickerModel mModel;
    private PickerActivity mView;

    @Inject
    public PickerPresenter(PickerModel model, PickerActivity view) {
        mModel = model;
        mView = view;
        getPickerInfo();
    }

    public void getPickerInfo() {
        mModel.getPickerInfo()
                .compose(RxHelper.handleResultBody())
                .subscribe(new RxDataSubscriber<JsonObject>(mView) {
                    @Override
                    protected void _onNext(JsonObject jsonObject) {
                        List<CwCataBean> cataList = gson.fromJson(jsonObject.get("cwCataList"), new TypeToken<List<CwCataBean>>() {
                        }.getType());
                        LogUtils.loge(cataList.toString());
                        mView.retrunCataList(cataList);


                    }

                    @Override
                    protected void _onError(String message) {
                        ToastUtil.showShort(message);
                    }
                });

    }

    public void getChooseList(Integer[] cateids) {
        mModel.getChooseList(cateids, null, null, 1, 1, "")
                .compose(RxHelper.handleResultBody())
                .subscribe(new RxDataSubscriber<JsonObject>(mView) {
                    @Override
                    protected void _onNext(JsonObject jsonObject) {
                        PageEntity<CourseBean> pageEntity = gson.fromJson(jsonObject.get("pagelist"), new TypeToken<PageEntity<CourseBean>>() {
                        }.getType());

                    }

                    @Override
                    protected void _onError(String message) {

                    }
                });
    }
}
