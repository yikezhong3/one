package com.boreas.quarterhour.api;

import com.boreas.quarterhour.model.LBModel;
import com.boreas.quarterhour.model.Splash;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by Dell on 2018/1/19.
 */

public interface ApiService {

    @GET("HPImageArchive.aspx?format=js&idx=0&n=1")
    Flowable<Splash> getLead();
    //轮播
    @GET("front/")
    Flowable<LBModel> getHome();

}
