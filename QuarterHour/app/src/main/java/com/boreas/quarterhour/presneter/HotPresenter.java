package com.boreas.quarterhour.presneter;


import android.util.Log;

import com.boreas.quarterhour.model.CarouselModel;
import com.boreas.quarterhour.model.BeenModel;
import com.boreas.quarterhour.model.RMBean;
import com.boreas.quarterhour.view.HotView;

import java.util.Map;

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
    public void getRMdata(Map<String, String> map){
        model.getRMData(new BeenModel.RMDataBack() {
            @Override
            public void callBack(RMBean bean) {
                view.onSuccessTn(bean);
            }
        }, map);
    }
}
