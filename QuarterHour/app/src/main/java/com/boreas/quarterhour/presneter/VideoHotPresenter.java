package com.boreas.quarterhour.presneter;

import com.boreas.quarterhour.base.BasePresenter;
import com.boreas.quarterhour.model.VideoHotBean;
import com.boreas.quarterhour.model.VideoHotLike;
import com.boreas.quarterhour.model.VideoHotLikeCallBack;
import com.boreas.quarterhour.model.VideoHotModel;
import com.boreas.quarterhour.model.VideoHotModelCallBack;
import com.boreas.quarterhour.view.fragment.Video.view.VideoHotView;

import javax.inject.Inject;

/**
 * Created by Lonely on 2018/1/25.
 */

public class VideoHotPresenter extends BasePresenter<VideoHotView> {

    @Inject
    public VideoHotModel videoHotModel;

    @Inject
    public VideoHotPresenter() {
        this.videoHotModel = new VideoHotModel();
    }

    public void login() {

        videoHotModel.getData(new VideoHotModelCallBack() {
            @Override
            public void success(VideoHotBean bean) {
                getView().success(bean);
            }
        });
    }

}
