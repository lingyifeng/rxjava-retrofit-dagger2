package com.alipay.lyf.rxjavasample.ui;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import com.alipay.lyf.rxjavasample.R;
import com.alipay.lyf.rxjavasample.base.MVPBaseActivity;
import com.alipay.lyf.rxjavasample.entity.CwCataBean;
import com.alipay.lyf.rxjavasample.inject.components.DaggerPickerComponent;
import com.alipay.lyf.rxjavasample.inject.modules.PickerModule;
import com.alipay.lyf.rxjavasample.ui.presenter.PickerPresenter;
import com.jiang.common.utils.LogUtils;
import com.jiang.common.widget.pickerview.OptionsPickerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.OnClick;


public class PickerActivity extends MVPBaseActivity<PickerPresenter> {

@BindView(R.id.bt_show)
    Button btShow;
    private ArrayList<CwCataBean> mLeftlist;
    private ArrayList<ArrayList<CwCataBean>> mrightLists;
    private OptionsPickerView mPickerView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_picker;
    }

    @Override
    protected void init() {

    }
    @OnClick(R.id.bt_show)
    public void onclick(View view){
        mPickerView.show();
    }

    @Override
    protected void initInjector() {
        DaggerPickerComponent.builder()
                .pickerModule(new PickerModule(this))
                .build().inject(this);
    }

    public void retrunCataList(List<CwCataBean> list) {
        HashMap<Integer, ArrayList<CwCataBean>> map = new HashMap<>();
        for (CwCataBean bean : list) {
            if (!map.containsKey(bean.getPid())) {
                ArrayList<CwCataBean> cwlist = new ArrayList<>();
                cwlist.add(bean);
                map.put(bean.getPid(), cwlist);
            } else {
                map.get(bean.getPid()).add(bean);
            }
        }

        mLeftlist = map.get(0);
        LogUtils.loge("size  "+mLeftlist.size());
        map.remove(0);
        mrightLists = new ArrayList<>();
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        int i=0;
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            ArrayList<CwCataBean> cwCataBeen = map.get(next);
            LogUtils.loge("cwsize1:  "+mLeftlist.size()+"next: "+next);
            cwCataBeen.add(0, mLeftlist.get(i));
            i++;
            LogUtils.loge("cwsize2:  "+cwCataBeen.size());
            mrightLists.add(cwCataBeen);
        }
        //设置滚轮文字大小
//设置分割线的颜色
//默认选中项
//是否只显示中间选中项的label文字，false则每项item全部都带有label。
//设置外部遮罩颜色
        mPickerView = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                Integer pid = mrightLists.get(options1).get(options2).getPid();
                Integer[] integers = new Integer[1];
                integers[0] = pid;
                mPresenter.getChooseList(integers);

            }
        }).setTitleText("课件选择")
                .setContentTextSize(20)//设置滚轮文字大小
                .setDividerColor(Color.GREEN)//设置分割线的颜色
                .setSelectOptions(0, 1)//默认选中项
                .setBgColor(Color.BLACK)
                .setTitleBgColor(Color.DKGRAY)
                .setTitleColor(Color.LTGRAY)
                .setCancelColor(Color.YELLOW)
                .setSubmitColor(Color.YELLOW)
                .setTextColorCenter(Color.LTGRAY)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
//                .setLabels("省", "市", "区")
                .setBackgroundId(0x66000000) //设置外部遮罩颜色
                .build();
        for (int j = 0; j < mrightLists.size(); j++) {
            LogUtils.loge("size:   "+mrightLists.get(j).size());
        }
//        LogUtils.loge("leftsize: "+mLeftlist+" rightsize: "+mrightLists.size());
        mPickerView.setPicker(mLeftlist, mrightLists);

    }
}
