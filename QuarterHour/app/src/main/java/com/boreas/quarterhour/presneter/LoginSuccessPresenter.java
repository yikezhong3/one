package com.boreas.quarterhour.presneter;

import com.boreas.quarterhour.model.LoginSuccesBean;
import com.boreas.quarterhour.model.LoginSuccessModelBack;
import com.boreas.quarterhour.view.LoginSuccesView;

/**
 * Created by dream on 2018/1/25.
 */

public class LoginSuccessPresenter implements LoginSuccessModelBack.SuccessBack{
    public final LoginSuccesView loginSuccesView;
    public final LoginSuccessModelBack loginSuccessModelBack;

    public LoginSuccessPresenter(LoginSuccesView loginSuccesView) {
        this.loginSuccesView = loginSuccesView;
        loginSuccessModelBack = new LoginSuccessModelBack(this);
    }

    public void getLoginUrl(String url,String mobile,String password){
        loginSuccessModelBack.getLoginUrl(url,mobile,password);
    }

    @Override
    public void SuccesBackData(LoginSuccesBean loginSuccesBean) {
        loginSuccesView.getData(loginSuccesBean);
    }
}
