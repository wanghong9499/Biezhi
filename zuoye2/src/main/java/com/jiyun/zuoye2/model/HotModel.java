package com.jiyun.zuoye2.model;

import android.util.Log;

import com.jiyun.zuoye2.bean.HotBean;
import com.jiyun.zuoye2.bean.OnlyBean;
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
 * Created by Administrator on 2019/3/3 0003.
 */

public class HotModel {
    private static final String TAG = "HotModel";

    public void initData(final ResultCallBack2<HotBean.RecentBean> resultCallBack2) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Apiservice.mBaseUrl2)
                .build();

        Apiservice apiservice = retrofit.create(Apiservice.class);
        Observable<HotBean> data = apiservice.initHotData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotBean HotBean) {
                        Log.d(TAG, "onNext: "+HotBean);
                        resultCallBack2.onSuccess(HotBean.getRecent());
                    }

                    @Override
                    public void onError(Throwable e) {
                        resultCallBack2.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
