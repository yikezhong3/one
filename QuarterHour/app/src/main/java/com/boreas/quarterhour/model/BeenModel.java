package com.boreas.quarterhour.model;

import com.boreas.quarterhour.model.api.Api;
import com.boreas.quarterhour.model.api.ApiService;
import com.boreas.quarterhour.utils.RetrofitClent;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by dream on 2018/1/25.
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
                    public void onNext(com.boreas.quarterhour.model.CarouselModel lbModel) {
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
    public void getRMData(final RMDataBack dataBack, Map<String, String> map){
        ApiService apiService = RetrofitClent.getRetrofitClientInstance().getApiService(ApiService.class, Api.lunbo);
        Flowable<RMBean> flowable = apiService.getRMdata(map);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<RMBean>() {
                    @Override
                    public void onNext(RMBean bean) {
                        dataBack.callBack(bean);
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
        void send(com.boreas.quarterhour.model.CarouselModel o);
    }
    public interface RMDataBack{
        void callBack(RMBean bean);
    }
}
