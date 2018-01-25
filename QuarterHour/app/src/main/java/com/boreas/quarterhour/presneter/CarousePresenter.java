package com.boreas.quarterhour.presneter;

import com.boreas.quarterhour.base.BasePresenter;
import com.boreas.quarterhour.model.CrossTalkBean;
import com.boreas.quarterhour.model.CrossTalkListModel;
import com.boreas.quarterhour.view.CrossTalkView;

/**
 * Created by Administrator on 2018/1/20.
 */

public class CarousePresenter extends BasePresenter<CrossTalkView> {
    CrossTalkListModel lieBiaoModel;
    CrossTalkView crossTalkView;
    public CarousePresenter(CrossTalkView crossTalkView) {
        this.lieBiaoModel=new CrossTalkListModel();
        this.crossTalkView = crossTalkView;
    }

    public void getLbData(){
        lieBiaoModel.getLbData(new CrossTalkListModel.LieBiaoData() {
            @Override
            public void liebiao(CrossTalkBean crossTalkBean) {
                crossTalkView.success(crossTalkBean);
            }
        });
    }
}
