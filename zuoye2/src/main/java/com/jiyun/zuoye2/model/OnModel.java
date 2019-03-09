package com.jiyun.zuoye2.model;

import android.util.Log;

import com.jiyun.zuoye2.bean.DayBean;
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
 * Created by Administrator on 2019/3/2 0002.
 */

public class OnModel {
    private static final String TAG = "OnModel";

    public void initData(final ResultCallBack2<OnlyBean.DataBean> resultCallBack2) {
            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(Apiservice.mBaseUrl2)
                    .build();

            Apiservice apiservice = retrofit.create(Apiservice.class);
            Observable<OnlyBean> data = apiservice.initOnlyData();
            data.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<OnlyBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(OnlyBean onlyBean) {
                            Log.d(TAG, "onNext: "+onlyBean.getData());
                            resultCallBack2.onSuccess(onlyBean.getData());
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
