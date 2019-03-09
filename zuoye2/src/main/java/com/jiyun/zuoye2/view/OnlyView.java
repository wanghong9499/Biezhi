package com.jiyun.zuoye2.view;


import com.jiyun.zuoye2.bean.OnlyBean;
import com.jiyun.zuoye2.bean.WxBean;

import java.util.List;

/**
 * Created by Administrator on 2019/3/1 0001.
 */

public interface OnlyView {
    void setData(List<OnlyBean.DataBean> o);

    void showToast(String message);
}
