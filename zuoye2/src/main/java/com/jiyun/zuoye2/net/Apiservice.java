package com.jiyun.zuoye2.net;


import com.jiyun.zuoye2.bean.DayBean;
import com.jiyun.zuoye2.bean.HotBean;
import com.jiyun.zuoye2.bean.OnlyBean;
import com.jiyun.zuoye2.bean.WxBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2019/3/1 0001.
 */

public interface Apiservice {
    String mBaseUrl = "http://api.tianapi.com/";

    @GET("wxnew")
    Observable<WxBean> initWxData(@Query("key") String key, @Query("num") int num, @Query("page") int page);

    String mBaseUrl2 = "http://news-at.zhihu.com/api/4/";
    @GET("news/latest")
    Observable<DayBean> initBannerData();

    @GET("sections")
    Observable<OnlyBean> initOnlyData();

    @GET("news/hot")
    Observable<HotBean> initHotData();
}
