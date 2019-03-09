package com.jiyun.zuoye2.view;

import com.jiyun.zuoye2.bean.HotBean;

import java.util.List;

/**
 * Created by Administrator on 2019/3/3 0003.
 */

public interface HotView {
    void setData(List<HotBean.RecentBean> o);

    void showToast(String message);
}
