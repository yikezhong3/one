package com.boreas.quarterhour.presneter;

import com.boreas.quarterhour.base.BasePresenter;
import com.boreas.quarterhour.model.SplashModel;
import com.boreas.quarterhour.view.SplashView;

import javax.inject.Inject;

/**
 * Created by Dell on 2018/1/22.
 */

public class SplashPresenter extends BasePresenter<SplashView> {

    SplashModel splashModel;
    @Inject
    public SplashPresenter(SplashModel splashModel) {
        this.splashModel = splashModel;
    }

    public void getdata() {
        splashModel.getSplash(new SplashModel.SplashInterface() {
            @Override
            public void success(String imgUrl) {

                getView().onSuccess(imgUrl);
            }
        });

    }
}
