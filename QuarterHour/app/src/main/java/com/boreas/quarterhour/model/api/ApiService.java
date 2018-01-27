package com.boreas.quarterhour.model.api;

import com.boreas.quarterhour.model.CrossTalkBean;
import com.boreas.quarterhour.model.CarouselModel;
import com.boreas.quarterhour.model.LoginSuccesBean;
import com.boreas.quarterhour.model.RMBean;
import com.boreas.quarterhour.model.Splash;
import com.boreas.quarterhour.model.VideoHotBean;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Dell on 2018/1/19.
 */

public interface ApiService {

    @GET("HPImageArchive.aspx?format=js&idx=0&n=1")
    Flowable<Splash> getLead();
    //轮播
    @GET("quarter/getAd")
    Flowable<CarouselModel> getHome();
    //段子列表
    //https://www.zhaoapi.cn/quarter/getJokes?source=android&appVersion=101&page=10
    @GET("quarter/getJokes")
    Flowable<CrossTalkBean> getDzLiebiao(@Query("appVersion") String appVersion, @Query("source") String source, @Query("page") String page);
    //登录
    @GET("user/login")
    Flowable<LoginSuccesBean> getLoginSuccess(@Query("mobile") String mobile,@Query("password") String password);
    //热门
    @GET("quarter/getHotVideos?token=F3768ABA31902C1D56B60F25708B9BCD&source=android&appVersion=101&page=1")
    Observable<VideoHotBean> getVideoHot();

    @GET("quarter/getHotVideos")
    Flowable<RMBean> getRMdata(@QueryMap Map<String, String> map);

}
