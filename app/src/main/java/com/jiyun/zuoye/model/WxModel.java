package com.jiyun.zuoye.model;

import android.util.Log;

import com.jiyun.zuoye.bean.WxBean;
import com.jiyun.zuoye.net.Apiservice;
import com.jiyun.zuoye.net.ResultCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2019/3/1 0001.
 */

public class WxModel {
    private static final String TAG = "WxModel";

    public void initData(int page, final ResultCallBack resultCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Apiservice.mBaseUrl)
                .build();

        Apiservice apiservice = retrofit.create(Apiservice.class);
        Observable<WxBean> data = apiservice.initWxData("52b7ec3471ac3bec6846577e79f20e4c",10,page);
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WxBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WxBean wxBean) {
                        Log.d(TAG, "onNext: "+wxBean);
                        resultCallBack.setData(wxBean.getNewslist());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: "+e.getMessage());
                        resultCallBack.showTost(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
