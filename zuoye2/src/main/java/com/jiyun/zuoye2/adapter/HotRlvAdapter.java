package com.jiyun.zuoye2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.zuoye2.R;
import com.jiyun.zuoye2.bean.HotBean;
import com.jiyun.zuoye2.bean.WxBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/1 0001.
 */

public class HotRlvAdapter extends RecyclerView.Adapter {
    private final Context mContext;
    public ArrayList<HotBean.RecentBean> mListt;

    public HotRlvAdapter(Context context, ArrayList<HotBean.RecentBean> listt) {

        mContext = context;
        mListt = listt;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.wx_item, null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        HotBean.RecentBean bean = mListt.get(position);
        holder1.mTitle.setText(bean.getTitle());
        Glide.with(mContext).load(bean.getThumbnail()).into(holder1.mImg);
    }

    @Override
    public int getItemCount() {
        return mListt.size();
    }

    public void addData(List<HotBean.RecentBean> o) {
        mListt.addAll(o);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mImg;
        private final TextView mTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.wx_img);
            mTitle = itemView.findViewById(R.id.wx_title);
        }
    }
}
