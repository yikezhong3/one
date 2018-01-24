package com.boreas.quarterhour.api;

import com.boreas.quarterhour.model.DZBean;
import com.boreas.quarterhour.model.LBModel;
import com.boreas.quarterhour.model.Splash;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Dell on 2018/1/19.
 */

public interface ApiService {

    @GET("HPImageArchive.aspx?format=js&idx=0&n=1")
    Flowable<Splash> getLead();
    //轮播
    @GET("quarter/getAd")
    Flowable<LBModel> getHome();
    //段子列表
    //https://www.zhaoapi.cn/quarter/getJokes?source=android&appVersion=101&page=10
    @GET("quarter/getJokes")
    Flowable<DZBean> getDzLiebiao(@Query("appVersion") String appVersion, @Query("source") String source, @Query("page") String page);

}
