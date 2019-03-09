package com.jiyun.zuoye2.presenter;

import com.jiyun.zuoye2.bean.DayBean;
import com.jiyun.zuoye2.bean.OnlyBean;
import com.jiyun.zuoye2.fragment.DayFragment;
import com.jiyun.zuoye2.model.DayModel;
import com.jiyun.zuoye2.model.OnModel;
import com.jiyun.zuoye2.net.ResultCallBack2;
import com.jiyun.zuoye2.view.DayView;
import com.jiyun.zuoye2.view.OnlyView;

import java.util.List;

/**
 * Created by Administrator on 2019/3/2 0002.
 */

public class DayPersenter {
    private DayView mView;
    private final DayModel mDayModel;

    public DayPersenter(DayView view) {
        mDayModel = new DayModel();
        mView = view;
    }

    public void initBannerData() {
        mDayModel.initBanner(new ResultCallBack2<DayBean.TopStoriesBean>() {
            @Override
            public void onSuccess(List<DayBean.TopStoriesBean> o) {
                mView.setBanner(o);
            }

            @Override
            public void onFail(String message) {
                mView.showTost(message);
            }
        });
    }

    public void initArticle() {
        mDayModel.initAriticle(new ResultCallBack2<DayBean.StoriesBean>() {
            @Override
            public void onSuccess(List<DayBean.StoriesBean> o) {
                mView.setArticle(o);
            }

            @Override
            public void onFail(String message) {
                mView.showTost(message);
            }
        });
    }
}
