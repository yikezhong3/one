package com.boreas.quarterhour.view.fragment.Video.view;

import com.boreas.quarterhour.model.VideoHotLike;

/**
 * Created by Lonely on 2018/2/1.
 */

public interface VideoHotLikeView {
    void likesuccess(VideoHotLike videoHotLike);
    void collectsuccess(VideoHotCollect videoHotCollectView);
}
