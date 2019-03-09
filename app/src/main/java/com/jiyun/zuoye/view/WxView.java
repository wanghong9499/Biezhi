package com.jiyun.zuoye.view;

import com.jiyun.zuoye.bean.WxBean;

import java.util.List;

/**
 * Created by Administrator on 2019/3/1 0001.
 */

public interface WxView {
    void setData(List<WxBean.NewslistBean> newslist);

    void showTost(String message);
}
