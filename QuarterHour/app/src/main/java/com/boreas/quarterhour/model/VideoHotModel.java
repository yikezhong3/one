package com.boreas.quarterhour.model;

import com.boreas.quarterhour.model.api.Api;
import com.boreas.quarterhour.model.api.ApiService;
import com.boreas.quarterhour.utils.RetrofitClent;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lonely on 2018/1/25.
 */

public class VideoHotModel {

    @Inject
    public VideoHotModel() {

    }

    public void getData(final VideoHotModelCallBack callBack){

       /* Map<String,String> map = new HashMap<>();
        map.put("token","F3768ABA31902C1D56B60F25708B9BCD");
        map.put("source","android");
        map.put("appVersion","101");
        map.put("page","1");*/
//        map.put("uid","101");
//        map.put("type","推荐  ");
//        map.put("page","10");

        ApiService apiService = RetrofitClent.getRetrofitClientInstance().getApiService(ApiService.class, Api.VIDEO_HOT);
        Observable<VideoHotBean> remen = apiService.getVideoHot();
        remen.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<VideoHotBean>() {
                    @Override
                    public void onNext(VideoHotBean videoHotBean) {
                        callBack.success(videoHotBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
