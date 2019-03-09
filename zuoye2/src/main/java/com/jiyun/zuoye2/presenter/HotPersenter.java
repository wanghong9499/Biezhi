package com.jiyun.zuoye2.presenter;

import com.jiyun.zuoye2.bean.HotBean;
import com.jiyun.zuoye2.model.HotModel;
import com.jiyun.zuoye2.net.ResultCallBack2;
import com.jiyun.zuoye2.view.HotView;

import java.util.List;

/**
 * Created by Administrator on 2019/3/3 0003.
 */

public class HotPersenter {
    private HotView mView;
    private final HotModel mHotModel;

    public HotPersenter(HotView view) {
        mHotModel = new HotModel();
        mView = view;
    }

    public void initData() {
        mHotModel.initData(new ResultCallBack2<HotBean.RecentBean>() {
            @Override
            public void onSuccess(List<HotBean.RecentBean> o) {
                mView.setData(o);
            }

            @Override
            public void onFail(String message) {
                mView.showToast(message);
            }
        });
    }
}
