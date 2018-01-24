package com.boreas.quarterhour.mvp.presenter;


import com.boreas.quarterhour.model.LBModel;
import com.boreas.quarterhour.mvp.model.BeenModel;
import com.boreas.quarterhour.mvp.view.RMView;

/**
 * Created by 123 on 2018/1/22.
 */

public class RMPresenter {
    private RMView view;
    private BeenModel model;
    public RMPresenter(RMView view) {
        this.view = view;
        this.model = new BeenModel();
    }
    public void getData(){
        model.getData(new BeenModel.SendData() {
            @Override
            public void send(LBModel model) {
                view.onSuccess(model);
            }
        });
    }
}
