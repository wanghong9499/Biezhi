package com.jiyun.zuoye2.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.zuoye2.R;
import com.jiyun.zuoye2.adapter.NewsVpAdapter;

import java.util.ArrayList;


/**
 * Created by Administrator on 2019/3/2 0002.
 */

public class NewsFragment extends Fragment {
    private View view;
    private TabLayout mTab1;
    private ViewPager mVp1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.newsfragment, null, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mTab1 = (TabLayout) inflate.findViewById(R.id.tab1);
        mVp1 = (ViewPager) inflate.findViewById(R.id.vp1);
//        mTab1.addTab(mTab1.newTab().setText("日报"));
//        mTab1.addTab(mTab1.newTab().setText("主题"));
//        mTab1.addTab(mTab1.newTab().setText("专栏"));
//        mTab1.addTab(mTab1.newTab().setText("热门"));
        ArrayList<String> tabList = new ArrayList<>();
        tabList.add("日报");
        tabList.add("主题");
        tabList.add("专栏");
        tabList.add("热门");

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new DayFragment());
        fragments.add(new FrameFragment());
        fragments.add(new OnlyFragment());
        fragments.add(new HotFragment());

        NewsVpAdapter vpAdapter = new NewsVpAdapter(getChildFragmentManager(), fragments,tabList);
        mVp1.setAdapter(vpAdapter);
        mTab1.setupWithViewPager(mVp1);
    }
}
