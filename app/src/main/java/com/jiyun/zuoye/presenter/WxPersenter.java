package com.jiyun.zuoye.presenter;

import com.jiyun.zuoye.bean.WxBean;
import com.jiyun.zuoye.fragment.WxFragment;
import com.jiyun.zuoye.model.WxModel;
import com.jiyun.zuoye.net.ResultCallBack;
import com.jiyun.zuoye.view.WxView;

import java.util.List;

/**
 * Created by Administrator on 2019/3/1 0001.
 */

public class WxPersenter {
    private WxView mView;
    private final WxModel mWxModel;

    public WxPersenter(WxView view) {
        mWxModel = new WxModel();
        mView = view;
    }

    public void initData(int page) {
        mWxModel.initData(page,new ResultCallBack(){
            @Override
            public void setData(List<WxBean.NewslistBean> newslist) {
                mView.setData(newslist);
            }

            @Override
            public void showTost(String message) {
                mView.showTost(message);
            }
        });
    }
}
