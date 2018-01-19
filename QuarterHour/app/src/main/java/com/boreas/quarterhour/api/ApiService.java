package com.boreas.quarterhour.api;

import com.boreas.quarterhour.model.LBModel;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by Dell on 2018/1/19.
 */

public interface ApiService {

    //轮播
    @GET("front/")
    Flowable<LBModel> getHome();

}
