package com.jiyun.zuoye.fragment;

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
import com.jiyun.zuoye.R;
import com.jiyun.zuoye.adapter.WxRlvAdapter;
import com.jiyun.zuoye.bean.WxBean;
import com.jiyun.zuoye.presenter.WxPersenter;
import com.jiyun.zuoye.view.WxView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/1 0001.
 */

public class WxFragment extends Fragment implements WxView{
    private View view;
    private XRecyclerView mRlv2;
    private ArrayList<WxBean.NewslistBean> mListt;
    private WxRlvAdapter mAdapter;
    private WxPersenter mWxPersenter;
    private int mPage = 1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.wxfragment, null, false);
        mWxPersenter = new WxPersenter(this);
        initView(inflate);
        initData(mPage);
        return inflate;
    }

    private void initData(int page) {
        mWxPersenter.initData(page);
    }

    private void initView(View inflate) {
        mRlv2 = (XRecyclerView) inflate.findViewById(R.id.rlv2);
        mRlv2.setLayoutManager(new LinearLayoutManager(getContext()));

        mListt = new ArrayList<>();
        mAdapter = new WxRlvAdapter(getContext(),mListt);
        mRlv2.setAdapter(mAdapter);

        mRlv2.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPage = 1;
                mAdapter.mListt.clear();
                initData(mPage);
            }

            @Override
            public void onLoadMore() {
                mPage++;
                initData(mPage);
            }
        });
    }

    @Override
    public void setData(List<WxBean.NewslistBean> newslist) {
        mAdapter.addData(newslist);
        mRlv2.refreshComplete();
        mRlv2.loadMoreComplete();
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
}
