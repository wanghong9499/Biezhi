package com.jiyun.zuoye2.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.zuoye2.R;
import com.jiyun.zuoye2.adapter.HotRlvAdapter;
import com.jiyun.zuoye2.bean.HotBean;
import com.jiyun.zuoye2.presenter.HotPersenter;
import com.jiyun.zuoye2.view.HotView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2019/3/1 0001.
 */

public class HotFragment extends Fragment implements HotView{
    private View view;
    private XRecyclerView mRlv5;
    private ArrayList<HotBean.RecentBean> mList;
    private HotRlvAdapter mAdapter;
    private HotPersenter mHotPersenter;
    private int mPage = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.hotfragment, null, false);
        mHotPersenter = new HotPersenter(this);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        mHotPersenter.initData();
    }

    private void initView(View inflate) {
        mRlv5 = (XRecyclerView) inflate.findViewById(R.id.rlv5);
        mRlv5.setLayoutManager(new GridLayoutManager(getContext(),2));

        mList = new ArrayList<>();
        mAdapter = new HotRlvAdapter(getContext(),mList);
        mRlv5.setAdapter(mAdapter);
    }

    @Override
    public void setData(List<HotBean.RecentBean> o) {
        mAdapter.addData(o);
    }

    @Override
    public void showToast(final String message) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
