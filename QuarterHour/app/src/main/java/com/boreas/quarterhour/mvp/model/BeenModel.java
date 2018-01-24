package com.boreas.quarterhour.mvp.model;

import com.boreas.quarterhour.api.Api;
import com.boreas.quarterhour.api.ApiService;
import com.boreas.quarterhour.model.LBModel;
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
        Flowable<LBModel> flowable = apiService.getHome();
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<LBModel>() {
                    @Override
                    public void onNext(com.boreas.quarterhour.model.LBModel lbModel) {
                        sendData.send(lbModel);

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
        void send(com.boreas.quarterhour.model.LBModel o);
    }

}
