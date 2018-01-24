package com.boreas.quarterhour.mvp.presenter;

import com.boreas.quarterhour.base.BasePresenter;
import com.boreas.quarterhour.model.DZBean;
import com.boreas.quarterhour.mvp.model.DzLieBiaoModel;
import com.boreas.quarterhour.mvp.view.DZView;

/**
 * Created by Administrator on 2018/1/20.
 */

public class LBPresenter extends BasePresenter<DZView> {
    DzLieBiaoModel lieBiaoModel;
    DZView dzView;
    public LBPresenter(DZView dzView) {
        this.lieBiaoModel=new DzLieBiaoModel();
        this.dzView=dzView;
    }

    public void getLbData(){
        lieBiaoModel.getLbData(new DzLieBiaoModel.LieBiaoData() {
            @Override
            public void liebiao(DZBean dzBean) {
                dzView.success(dzBean);
            }
        });
    }
}
