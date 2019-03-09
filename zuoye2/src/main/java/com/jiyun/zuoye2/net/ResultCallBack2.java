package com.jiyun.zuoye2.net;

import java.util.List;

/**
 * Created by Administrator on 2019/3/2 0002.
 */

public interface ResultCallBack2<T> {
    void onSuccess(List<T> o);

    void onFail(String message);
}
