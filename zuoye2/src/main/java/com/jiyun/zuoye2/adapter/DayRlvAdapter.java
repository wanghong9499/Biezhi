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
import com.jiyun.zuoye2.bean.DayBean;
import com.jiyun.zuoye2.bean.WxBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/1 0001.
 */

public class DayRlvAdapter extends RecyclerView.Adapter {

    private final Context mContext;
    private final ArrayList<DayBean.TopStoriesBean> mBannerList;
    private final ArrayList<DayBean.StoriesBean> mAriticleList;

    public DayRlvAdapter(Context context, ArrayList<DayBean.TopStoriesBean> bannerList, ArrayList<DayBean.StoriesBean> ariticleList) {

        mContext = context;
        mBannerList = bannerList;
        mAriticleList = ariticleList;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 && mBannerList.size() > 0){
            return 1;
        }else {
            return 2;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1){
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.daybanner, null, false);
            return new ViewHolder2(inflate);
        }else {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.day_item, null, false);
            return new ViewHolder1(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 1){
            ViewHolder2 holder1 = (ViewHolder2) holder;
            holder1.mBanner.setImages(mBannerList);
            holder1.mBanner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    DayBean.TopStoriesBean path1 = (DayBean.TopStoriesBean) path;
                    Glide.with(mContext).load(path1.getImage()).into(imageView);
                }
            });
            holder1.mBanner.start();
        }else {
            int newsPosition = position;
            if (mBannerList.size() > 0){
                newsPosition = position-1;
            }
            ViewHolder1 holder1 = (ViewHolder1) holder;
            DayBean.StoriesBean bean = mAriticleList.get(newsPosition);
            holder1.mTitle.setText(bean.getTitle());
            Glide.with(mContext).load(bean.getImages().get(0)).into(holder1.mImg);
        }
    }

    @Override
    public int getItemCount() {
        if (mBannerList.size() > 0){
            return mAriticleList.size() + 1;
        }else {
            return mAriticleList.size();
        }
    }


    public void addBanner(List<DayBean.TopStoriesBean> o) {
        mBannerList.addAll(o);
        notifyDataSetChanged();
    }

    public void setArticle(List<DayBean.StoriesBean> o) {
        mAriticleList.addAll(o);
        notifyDataSetChanged();
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {


        private final ImageView mImg;
        private final TextView mTitle;

        public ViewHolder1(View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.day_img);
            mTitle = itemView.findViewById(R.id.day_title);
        }
    }
    class ViewHolder2 extends RecyclerView.ViewHolder {


        private final Banner mBanner;

        public ViewHolder2(View itemView) {
            super(itemView);
            mBanner = itemView.findViewById(R.id.banner);
        }
    }
}
