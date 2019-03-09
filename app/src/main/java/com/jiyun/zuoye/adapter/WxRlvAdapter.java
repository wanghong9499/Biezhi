package com.jiyun.zuoye.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.zuoye.R;
import com.jiyun.zuoye.bean.WxBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/1 0001.
 */

public class WxRlvAdapter extends RecyclerView.Adapter {
    private final Context mContext;
    public ArrayList<WxBean.NewslistBean> mListt;

    public WxRlvAdapter(Context context, ArrayList<WxBean.NewslistBean> listt) {

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
        WxBean.NewslistBean bean = mListt.get(position);
        holder1.mTitle.setText(bean.getTitle());
        holder1.mAuthor.setText(bean.getDescription());
        holder1.mTime.setText(bean.getCtime());
        Glide.with(mContext).load(bean.getPicUrl()).into(holder1.mImg);
    }

    @Override
    public int getItemCount() {
        return mListt.size();
    }

    public void addData(List<WxBean.NewslistBean> newslist) {
        mListt.addAll(newslist);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mImg;
        private final TextView mTitle;
        private final TextView mAuthor;
        private final TextView mTime;

        public ViewHolder(View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.wx_img);
            mTitle = itemView.findViewById(R.id.wx_title);
            mAuthor = itemView.findViewById(R.id.wx_author);
            mTime = itemView.findViewById(R.id.wx_time);
        }
    }
}
