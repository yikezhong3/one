package com.boreas.quarterhour.model.api;

import com.boreas.quarterhour.model.LoginSuccesBean;
import com.boreas.quarterhour.model.LoginSuccessModel;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dream on 2018/1/25.
 */

public class LoginSuccessModelBack implements LoginSuccessModel {
    SuccessBack successBack;

    public LoginSuccessModelBack(SuccessBack successBack) {
        this.successBack = successBack;
    }

    public interface SuccessBack{
        void SuccesBackData(LoginSuccesBean loginSuccesBean);
    }
    @Override
    public void getLoginUrl(String url,String mobile,String password) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Flowable<LoginSuccesBean> loginSuccess = apiService.getLoginSuccess(mobile, password);
        loginSuccess.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<LoginSuccesBean>() {
                    @Override
                    public void onNext(LoginSuccesBean loginSuccesBean) {
                        LoginSuccesBean.DataBean data = loginSuccesBean.getData();
                        successBack.SuccesBackData(loginSuccesBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
