package com.boreas.quarterhour.utils.dagger;

import com.boreas.quarterhour.view.activity.LeadActivity;
import com.boreas.quarterhour.view.activity.VideoHotDetailsActivity;
import com.boreas.quarterhour.view.fragment.Video.SPRMFragment;
import com.boreas.quarterhour.view.fragment.VideoFragment;

import dagger.Component;

/**
 * Created by Dell on 2017/12/12.
 */
@Component(modules = MyMoudle.class)
public interface MyComponent {
    public void inject(LeadActivity lead);
    public void injectsp(SPRMFragment videohotFragment);

    public void injectsp_video(VideoHotDetailsActivity videoHotDetailsActivity);

}
