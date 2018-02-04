package com.boreas.quarterhour.model.api;

import com.boreas.quarterhour.model.AttentionBean;
import com.boreas.quarterhour.model.BendiBean;
import com.boreas.quarterhour.model.CollectBean;
import com.boreas.quarterhour.model.CrossTalkBean;
import com.boreas.quarterhour.model.CarouselModel;
import com.boreas.quarterhour.model.LoginSuccesBean;
import com.boreas.quarterhour.model.RegisterBean;
import com.boreas.quarterhour.model.RMBean;
import com.boreas.quarterhour.model.SelectBean;
import com.boreas.quarterhour.model.Splash;
import com.boreas.quarterhour.model.UserDetailBean;
import com.boreas.quarterhour.model.VideoHotBean;
import com.boreas.quarterhour.model.VideoHotLike;
import com.boreas.quarterhour.view.fragment.Video.view.VideoHotCollect;

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

    //搜索好友
    @GET("quarter/randomFriends?source=android&appVersion=1")
    Flowable<SelectBean> getSelect();

    //bendi
    @GET("travel/?key=ac87b4a4e634eb4a4e96fd371490a667&num=21")
    Flowable<BendiBean> getBendi();

    //bendi
    @GET("/meinv/?key=ac87b4a4e634eb4a4e96fd371490a667&num=9")
    Flowable<BendiBean> getYi();

    //注册
    @GET("quarter/register")
    Flowable<RegisterBean> getRegisterSuccess(@Query("regType") int regType, @Query("mobile") String mobile, @Query("password") String password);

    //关注
    @GET("quarter/getFollowUsers")
    Flowable<AttentionBean> getAttention(@Query("uid") int uid, @Query("token") String token, @Query("source") String source, @Query("appVersion") String appVersion);

    //收藏
    @GET("quarter/getFavorites")
    Flowable<CollectBean> getCollect(@Query("uid") int uid, @Query("token") String token, @Query("source") String source, @Query("appVersion") String appVersion);

    @GET("quarter/getHotVideos")
    Flowable<RMBean> getRMdata(@QueryMap Map<String, String> map);

    //视频热门点赞
    @GET("quarter/praise?source=android&appVersion=101")
    Flowable<VideoHotLike> getVideoHotLike(@Query("token") String token, @Query("uid") String uid, @Query("wid") String wid);
    //视频热门点赞
    @GET("quarter/addFavorite?source=android&appVersion=101")
    Flowable<VideoHotCollect> getVideoHotCollect(@Query("token") String token, @Query("uid") String uid, @Query("wid") String wid);

    @GET("quarter/getUserVideos")
    Flowable<UserDetailBean> getUserDetailsData(@QueryMap Map<String, String> map);

}
