package com.jiyun.zuoye2.model;

import android.util.Log;

import com.jiyun.zuoye2.bean.DayBean;
import com.jiyun.zuoye2.bean.WxBean;
import com.jiyun.zuoye2.net.Apiservice;
import com.jiyun.zuoye2.net.ResultCallBack2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2019/3/2 0002.
 */

public class DayModel {
    private static final String TAG = "DayModel";

    public void initBanner(final ResultCallBack2<DayBean.TopStoriesBean> resultCallBack2) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Apiservice.mBaseUrl2)
                .build();

        Apiservice apiservice = retrofit.create(Apiservice.class);
        Observable<DayBean> data = apiservice.initBannerData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DayBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DayBean dayBean) {
                        Log.d(TAG, "onNext: "+dayBean);
                        resultCallBack2.onSuccess(dayBean.getTop_stories());
                    }

                    @Override
                    public void onError(Throwable e) {
                        resultCallBack2.onFail(e.getMessage());
                        Log.d(TAG, "onError: "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void initAriticle(final ResultCallBack2<DayBean.StoriesBean> resultCallBack2) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Apiservice.mBaseUrl2)
                .build();

        Apiservice apiservice = retrofit.create(Apiservice.class);
        Observable<DayBean> data = apiservice.initBannerData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DayBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DayBean dayBean) {
                        Log.d(TAG, "onNext: "+dayBean);
                        resultCallBack2.onSuccess(dayBean.getStories());
                    }

                    @Override
                    public void onError(Throwable e) {
                        resultCallBack2.onFail(e.getMessage());
                        Log.d(TAG, "onError: "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
