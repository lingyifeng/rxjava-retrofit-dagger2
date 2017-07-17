package com.alipay.lyf.rxjavasample.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.alipay.lyf.rxjavasample.R;
import com.alipay.lyf.rxjavasample.entity.PlanDetailEntity;
import com.alipay.lyf.rxjavasample.helper.recyclerview.BaseRecyclerAdapter;
import com.alipay.lyf.rxjavasample.helper.recyclerview.IViewHolder;

import java.util.List;

/**
 * Created by 01F on 2017/6/10.
 */

public class PlanAdapter extends BaseRecyclerAdapter<PlanDetailEntity> {
    public PlanAdapter(Context context, List<PlanDetailEntity> list) {
        super(context, list);
    }

    @Override
    public IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.irv_item, parent, false);
        return new PlanHolder(view);
    }

    @Override
    public int getItemCount() {
        return list.size() > 0 ? list.size() : 0;
    }

    public class PlanHolder extends IViewHolder<PlanDetailEntity> {

        private RecyclerView mIrvShow;

        public PlanHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void setData(PlanDetailEntity data) {
            super.setData(data);
            setText(R.id.tv_show, data.getTitle())
                    .setImageLoder(R.id.iv_show, data.getReadimg(), mContext);
            mIrvShow = getView(R.id.irv_show);
            TestAdapter adapter = new TestAdapter(mContext, list);
            mIrvShow.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
            mIrvShow.setAdapter(adapter);

//            RecyclerViewInit.init(mContext,mIrvShow,adapter,new FullyLinearLayoutManager(mContext),LinearLayoutManager.HORIZONTAL);

        }
    }
}
