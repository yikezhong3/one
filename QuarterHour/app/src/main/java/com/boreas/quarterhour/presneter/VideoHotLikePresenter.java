package com.boreas.quarterhour.presneter;

import android.util.Log;

import com.boreas.quarterhour.base.BasePresenter;
import com.boreas.quarterhour.model.VideoHotLike;
import com.boreas.quarterhour.model.VideoHotLikeCallBack;
import com.boreas.quarterhour.model.VideoHotLikeModel;
import com.boreas.quarterhour.model.VideoHotModel;
import com.boreas.quarterhour.view.fragment.Video.view.VideoHotCollect;
import com.boreas.quarterhour.view.fragment.Video.view.VideoHotLikeView;
import com.boreas.quarterhour.view.fragment.Video.view.VideoHotView;

import javax.inject.Inject;

/**
 * Created by Lonely on 2018/2/1.
 */

public class VideoHotLikePresenter extends BasePresenter<VideoHotLikeView> {

    @Inject
    public VideoHotLikeModel videoHotLikeModel;

    @Inject
    public VideoHotLikePresenter() {
        this.videoHotLikeModel = new VideoHotLikeModel();
    }

    public void likelogin(final String uid , final String token , final String wid) {

        videoHotLikeModel.getLikeData(uid , token , wid,new VideoHotLikeCallBack() {
            @Override
            public void likesuccess(VideoHotLike videoHotLike) {
                Log.d("uid+wid-getlike-like",uid+"-"+wid+"-"+token);
                getView().likesuccess(videoHotLike);
            }

            @Override
            public void collectsuccess(VideoHotCollect videoHotCollect) {
                Log.d("uid+wid-getlike-collect",uid+"-"+wid);
                getView().collectsuccess(videoHotCollect);
            }
        });
    }
    public void collectlogin(final String uid , final String token , final String wid) {

        videoHotLikeModel.getCollectData(uid , token , wid , new VideoHotLikeCallBack() {
            @Override
            public void likesuccess(VideoHotLike videoHotLike) {
                Log.d("uid+wid-getcollect-like",uid+"-"+wid+"-"+token);
                getView().likesuccess(videoHotLike);
            }

            @Override
            public void collectsuccess(VideoHotCollect videoHotCollect) {
                Log.d("uid+wid-getcoll-collect",uid+"-"+wid);
                getView().collectsuccess(videoHotCollect);
            }
        });
    }
}
