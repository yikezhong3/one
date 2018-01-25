package com.boreas.quarterhour.presneter;


import com.boreas.quarterhour.model.CarouselModel;
import com.boreas.quarterhour.model.BeenModel;
import com.boreas.quarterhour.view.HotView;

/**
 * Created by 123 on 2018/1/22.
 */

public class HotPresenter {
    private HotView view;
    private BeenModel model;
    public HotPresenter(HotView view) {
        this.view = view;
        this.model = new BeenModel();
    }
    public void getData(){
        model.getData(new BeenModel.SendData() {
            @Override
            public void send(CarouselModel model) {
                view.onSuccess(model);
            }
        });
    }
}
