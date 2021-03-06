package com.jiyun.zuoye.net;

import com.jiyun.zuoye.bean.WxBean;

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
    Observable<WxBean> initWxData( @Query("key") String key,@Query("num") int num,@Query("page") int page);
}
