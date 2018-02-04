package com.boreas.quarterhour.model;

import android.util.Log;

import com.boreas.quarterhour.model.api.Api;
import com.boreas.quarterhour.model.api.ApiService;
import com.boreas.quarterhour.model.message.MessageEvent;
import com.boreas.quarterhour.utils.RetrofitClent;
import com.boreas.quarterhour.view.fragment.Video.view.VideoHotCollect;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by Lonely on 2018/2/1.
 */

public class VideoHotLikeModel {

    @Inject
    public VideoHotLikeModel() {

    }

    public void getLikeData(String uid , String token , String wid,final VideoHotLikeCallBack callBack){

       /* Map<String,String> map = new HashMap<>();
        map.put("token","F3768ABA31902C1D56B60F25708B9BCD");
        map.put("source","android");
        map.put("appVersion","101");
        map.put("page","1");*/
//        map.put("uid","101");
//        map.put("type","推荐  ");
//        map.put("page","10");
//        Log.d("uid+wid+token",uid+"--"+wid+"--"+token);
//        Log.d("uid+wid+token","jinlaile");
        System.out.println("uid+wid+token-likemodel = " + uid+"-"+wid+"-"+token);
        ApiService apiService = RetrofitClent.getRetrofitClientInstance().getApiService(ApiService.class, Api.VIDEO_HOT);
        Flowable<VideoHotLike> remen = apiService.getVideoHotLike(token,uid,wid);
        remen.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSubscriber<VideoHotLike>() {
                    @Override
                    public void onNext(VideoHotLike videoHotLike) {
                        callBack.likesuccess(videoHotLike);
//                        EventBus.getDefault().post(new MessageEvent(videoHotLike.getMsg()));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void getCollectData(String uid ,String token , String wid , final VideoHotLikeCallBack callBack){

       /* Map<String,String> map = new HashMap<>();
        map.put("token","F3768ABA31902C1D56B60F25708B9BCD");
        map.put("source","android");
        map.put("appVersion","101");
        map.put("page","1");*/
//        map.put("uid","101");
//        map.put("type","推荐  ");
//        map.put("page","10");
//        Log.d("uid+wid+token",uid+"--"+wid+"--"+token);
//        Log.d("uid+wid+token","jinlaile");
        System.out.println("uid+wid+token-collectmodel = " + uid+"-"+wid+"-"+token);
        ApiService apiService = RetrofitClent.getRetrofitClientInstance().getApiService(ApiService.class, Api.VIDEO_HOT);
        Flowable<VideoHotCollect> remen = apiService.getVideoHotCollect(token,uid,wid);
        remen.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSubscriber<VideoHotCollect>() {
                    @Override
                    public void onNext(VideoHotCollect videoHotCollect) {
                        callBack.collectsuccess(videoHotCollect);
//                        EventBus.getDefault().post(new MessageEvent(videoHotLike.getMsg()));
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
