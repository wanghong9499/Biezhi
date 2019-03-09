package com.jiyun.zuoye2.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/3/1 0001.
 */

public class NewsVpAdapter extends FragmentPagerAdapter {
    private final ArrayList<Fragment> mFragments;
    private final ArrayList<String> mTabList;

    public NewsVpAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String> tabList) {
        super(fm);
        mFragments = fragments;
        mTabList = tabList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTabList.get(position);
    }
}
