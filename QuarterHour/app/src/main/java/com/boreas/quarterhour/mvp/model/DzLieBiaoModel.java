package com.boreas.quarterhour.mvp.model;

import com.boreas.quarterhour.api.Api;
import com.boreas.quarterhour.api.ApiService;
import com.boreas.quarterhour.model.DZBean;
import com.boreas.quarterhour.utils.RetrofitClent;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by Administrator on 2018/1/20.
 */

public class DzLieBiaoModel {
    public DzLieBiaoModel(){}
    public void getLbData(final DzLieBiaoModel.LieBiaoData lieBiaoData){

        ApiService apiService = RetrofitClent.getRetrofitClientInstance().getApiService(ApiService.class, Api.DzLieBiao);

        Flowable<DZBean> flowable = apiService.getDzLiebiao("101","android","10");
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<DZBean>() {

                    @Override
                    public void onNext(DZBean dzBean) {
                        lieBiaoData.liebiao(dzBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    public interface LieBiaoData{
        void liebiao(com.boreas.quarterhour.model.DZBean dzBean);
    }
}
