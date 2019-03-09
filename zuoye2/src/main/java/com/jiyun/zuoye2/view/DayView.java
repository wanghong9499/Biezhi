package com.jiyun.zuoye2.view;

import com.jiyun.zuoye2.bean.DayBean;

import java.util.List;

/**
 * Created by Administrator on 2019/3/2 0002.
 */

public interface DayView {
    void setBanner(List<DayBean.TopStoriesBean> o);

    void showTost(String message);

    void setArticle(List<DayBean.StoriesBean> o);
}
