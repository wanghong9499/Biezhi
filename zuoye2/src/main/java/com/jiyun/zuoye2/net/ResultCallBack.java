package com.jiyun.zuoye2.net;


import com.jiyun.zuoye2.bean.WxBean;

import java.util.List;

/**
 * Created by Administrator on 2019/3/1 0001.
 */

public interface ResultCallBack {
    void setData(List<WxBean.NewslistBean> newslist);

    void showTost(String message);
}
