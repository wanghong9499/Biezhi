package com.jiyun.zuoye2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.zuoye2.R;
import com.jiyun.zuoye2.bean.OnlyBean;
import com.jiyun.zuoye2.bean.WxBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/1 0001.
 */

public class OnlyRlvAdapter extends RecyclerView.Adapter {
    private static final String TAG = "OnlyRlvAdapter";
    private final Context mContext;
    private ArrayList<OnlyBean.DataBean> mListt;

    public OnlyRlvAdapter(Context context, ArrayList<OnlyBean.DataBean> listt) {
        mContext = context;
        mListt = listt;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.only_item, null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        OnlyBean.DataBean bean = mListt.get(position);
        Log.d(TAG, "onBindViewHolder: "+bean.getDescription());
        Glide.with(mContext).load(bean.getThumbnail()).into(holder1.mImg);

    }

    @Override
    public int getItemCount() {
        return mListt.size();
    }

    public void setData(List<OnlyBean.DataBean> o) {
        mListt.addAll(o);
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mImg;

        public ViewHolder(View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.only_img);
        }
    }
}
