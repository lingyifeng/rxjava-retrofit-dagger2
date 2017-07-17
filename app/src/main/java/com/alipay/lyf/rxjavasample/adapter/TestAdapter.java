package com.alipay.lyf.rxjavasample.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.alipay.lyf.rxjavasample.R;
import com.alipay.lyf.rxjavasample.entity.PlanDetailEntity;
import com.alipay.lyf.rxjavasample.helper.recyclerview.BaseRecyclerAdapter;
import com.alipay.lyf.rxjavasample.helper.recyclerview.IViewHolder;

import java.util.List;

/**
 * Created by 01F on 2017/6/20.
 */

public class TestAdapter extends BaseRecyclerAdapter<PlanDetailEntity> {
    public TestAdapter(Context context, List<PlanDetailEntity> list) {
        super(context, list);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item, parent, false);
        return new TestHolder(view);
    }

    public class TestHolder extends IViewHolder<PlanDetailEntity>{

        public TestHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void setData(PlanDetailEntity data) {
            super.setData(data);
            setText(R.id.tv_show,data.getTitle());
            setImageLoder(R.id.iv_show,data.getReadimg(),mContext);
        }
    }
}
