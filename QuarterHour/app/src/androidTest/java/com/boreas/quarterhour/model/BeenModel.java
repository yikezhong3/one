package com.boreas.quarterhour.model;

import com.boreas.quarterhour.model.api.Api;
import com.boreas.quarterhour.model.api.ApiService;
import com.boreas.quarterhour.utils.RetrofitClent;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * 轮播图请求model
 */

public class BeenModel {

    public BeenModel() {
    }

    public void getData(final SendData sendData){

        ApiService apiService = RetrofitClent.getRetrofitClientInstance().getApiService(ApiService.class, Api.lunbo);
        Flowable<CarouselModel> flowable = apiService.getHome();
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<CarouselModel>() {
                    @Override
                    public void onNext(CarouselModel carouselModel) {
                        sendData.send(carouselModel);

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public interface SendData{
        void send(CarouselModel o);
    }

}
