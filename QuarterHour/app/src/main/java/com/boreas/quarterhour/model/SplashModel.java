package com.boreas.quarterhour.model;

import android.util.Log;

import com.boreas.quarterhour.model.api.Api;
import com.boreas.quarterhour.model.api.ApiService;
import com.boreas.quarterhour.utils.RetrofitClent;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by dream on 2018/1/25.
 */

public class SplashModel {
    @Inject
    public SplashModel() {

    }
    public void getSplash(final SplashInterface  splashInterface) {

        ApiService apiService = RetrofitClent.getRetrofitClientInstance().getApiService(ApiService.class, Api.SPLASHBASEURL);
        Flowable<Splash> flowable = apiService.getLead();
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<Splash>() {
                    @Override
                    public void onNext(Splash splash) {
                        Log.e("wwww", splash.getUrl().toString());
                        splashInterface.success(splash.getUrl());
                        if(splash == null){
                            Log.e("xxx","1");
                        }else{
                            Log.e("xxx","2");
                        }
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    public interface SplashInterface {
        void success(String imgUrl);
    }
}
