package com.jiyun.zuoye2.presenter;

import com.jiyun.zuoye2.bean.OnlyBean;
import com.jiyun.zuoye2.model.OnModel;
import com.jiyun.zuoye2.net.ResultCallBack2;
import com.jiyun.zuoye2.view.OnlyView;

import java.util.List;

/**
 * Created by Administrator on 2019/3/2 0002.
 */

public class OnlyPersenter {
    private OnlyView mView;
    private final OnModel mDayModel;

    public OnlyPersenter(OnlyView view) {
        mDayModel = new OnModel();
        mView = view;
    }

    public void initData() {
        mDayModel.initData(new ResultCallBack2<OnlyBean.DataBean>() {
            @Override
            public void onSuccess(List<OnlyBean.DataBean> o) {
                mView.setData(o);
            }

            @Override
            public void onFail(String message) {
                mView.showToast(message);
            }
        });
    }
}
