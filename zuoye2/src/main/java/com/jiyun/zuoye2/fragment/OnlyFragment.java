package com.jiyun.zuoye2.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.zuoye2.R;
import com.jiyun.zuoye2.adapter.DayRlvAdapter;
import com.jiyun.zuoye2.adapter.OnlyRlvAdapter;
import com.jiyun.zuoye2.bean.DayBean;
import com.jiyun.zuoye2.bean.OnlyBean;
import com.jiyun.zuoye2.presenter.DayPersenter;
import com.jiyun.zuoye2.presenter.OnlyPersenter;
import com.jiyun.zuoye2.view.DayView;
import com.jiyun.zuoye2.view.OnlyView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2019/3/1 0001.
 */

public class OnlyFragment extends Fragment implements OnlyView{
    private View view;
    private XRecyclerView mRlv4;
    private OnlyRlvAdapter mAdapter;
    private ArrayList<OnlyBean.DataBean> mList;
    private OnlyPersenter mDayPersenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.onlyfragment, null, false);
        initView(inflate);
        mDayPersenter = new OnlyPersenter(this);
        initData();
        return inflate;
    }

    private void initData() {
        mDayPersenter.initData();
    }

    private void initView(View inflate) {
        mRlv4 = (XRecyclerView) inflate.findViewById(R.id.rlv4);
        mRlv4.setLayoutManager(new GridLayoutManager(getContext(),2));

        mList = new ArrayList<>();
        mAdapter = new OnlyRlvAdapter(getContext(),mList);
        mRlv4.setAdapter(mAdapter);
    }

    @Override
    public void setData(List<OnlyBean.DataBean> o) {
        mAdapter.setData(o);
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
