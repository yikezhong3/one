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
 * Created by 123 on 2018/1/30.
 */

public class UserDetailsModel {
    public UserDetailsModel(){

    }
    public void getData(final GetDataCallBack callBack, Map<String , String> map){
        ApiService apiService = RetrofitClent.getRetrofitClientInstance().getApiService(ApiService.class, Api.lunbo);
        Flowable<UserDetailBean> flowable = apiService.getUserDetailsData(map);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<UserDetailBean>() {
                    @Override
                    public void onNext(UserDetailBean userDetailBean) {
                        callBack.callBack(userDetailBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public interface GetDataCallBack{
        void callBack(UserDetailBean bean);
    }
}
