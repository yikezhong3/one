package com.boreas.quarterhour.model;

import com.boreas.quarterhour.model.api.Api;
import com.boreas.quarterhour.model.api.ApiService;
import com.boreas.quarterhour.utils.RetrofitClent;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by dream on 2018/1/25.
 */

public class CrossTalkListModel {
    public CrossTalkListModel(){}
    public void getLbData(final CrossTalkListModel.LieBiaoData lieBiaoData){

        ApiService apiService = RetrofitClent.getRetrofitClientInstance().getApiService(ApiService.class, Api.DzLieBiao);

        Flowable<CrossTalkBean> flowable = apiService.getDzLiebiao("101","android","10");
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<CrossTalkBean>() {

                    @Override
                    public void onNext(CrossTalkBean dzBean) {
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
        void liebiao(com.boreas.quarterhour.model.CrossTalkBean dzBean);
    }
}
