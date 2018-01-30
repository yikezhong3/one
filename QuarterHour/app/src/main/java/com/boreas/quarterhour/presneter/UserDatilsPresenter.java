package com.boreas.quarterhour.presneter;

import com.boreas.quarterhour.model.UserDetailBean;
import com.boreas.quarterhour.model.UserDetailsModel;
import com.boreas.quarterhour.view.activity.UserDetailsActivity;
import com.boreas.quarterhour.view.myapp.UserDatilsView;

import java.util.Map;

/**
 * Created by 123 on 2018/1/30.
 */

public class UserDatilsPresenter {

    private UserDatilsView datilsView;
    private UserDetailsModel model;
    public UserDatilsPresenter(UserDatilsView datilsView) {
        this.datilsView = datilsView;
        this.model = new UserDetailsModel();
    }
    public void getData(Map<String, String> map){
        model.getData(new UserDetailsModel.GetDataCallBack() {
            @Override
            public void callBack(UserDetailBean bean) {
                datilsView.onSuccess(bean);
            }
        }, map);
    }
}
