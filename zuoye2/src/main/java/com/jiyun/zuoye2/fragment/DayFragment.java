package com.jiyun.zuoye2.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.zuoye2.R;
import com.jiyun.zuoye2.adapter.DayRlvAdapter;
import com.jiyun.zuoye2.adapter.WxRlvAdapter;
import com.jiyun.zuoye2.bean.DayBean;
import com.jiyun.zuoye2.presenter.DayPersenter;
import com.jiyun.zuoye2.view.DayView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2019/3/1 0001.
 */

public class DayFragment extends Fragment implements DayView{
    private View view;
    private XRecyclerView mRlv1;
    private DayRlvAdapter mAdapter;
    private ArrayList<DayBean.TopStoriesBean> mBannerList;
    private ArrayList<DayBean.StoriesBean> mAriticleList;
    private DayPersenter mDayPersenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dayfragment, null, false);
        mDayPersenter = new DayPersenter(this);
        initView(inflate);
        initBanner();
        initArticle();
        return inflate;
    }

    private void initArticle() {
        mDayPersenter.initArticle();
    }

    private void initBanner() {
        mDayPersenter.initBannerData();
    }

    private void initView(View inflate) {
        mRlv1 = (XRecyclerView) inflate.findViewById(R.id.rlv1);
        mRlv1.setLayoutManager(new LinearLayoutManager(getContext()));

        mBannerList = new ArrayList<>();
        mAriticleList = new ArrayList<>();
        mAdapter = new DayRlvAdapter(getContext(), mBannerList,mAriticleList);
        mRlv1.setAdapter(mAdapter);
    }

    @Override
    public void setBanner(List<DayBean.TopStoriesBean> o) {
        mAdapter.addBanner(o);
    }

    @Override
    public void showTost(final String message) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void setArticle(List<DayBean.StoriesBean> o) {
        mAdapter.setArticle(o);
    }
}
