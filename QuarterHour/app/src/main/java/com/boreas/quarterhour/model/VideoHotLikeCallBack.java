package com.boreas.quarterhour.model;

import com.boreas.quarterhour.view.fragment.Video.view.VideoHotCollect;

/**
 * Created by Lonely on 2018/1/31.
 */

public interface VideoHotLikeCallBack {
    void likesuccess(VideoHotLike videoHotLike);
    void collectsuccess(VideoHotCollect videoHotCollect);
}
