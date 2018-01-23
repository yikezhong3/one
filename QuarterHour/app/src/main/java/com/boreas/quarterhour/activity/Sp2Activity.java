package com.boreas.quarterhour.activity;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.base.BaseActivity;
import com.boreas.quarterhour.base.BasePresenter;

public class Sp2Activity extends BaseActivity {

    @Override
    protected void initDagger() {

    }

    @Override
    protected void initView() {
    }

    @Override
    protected boolean enableSliding() {
        return true;
    }
    @Override
    public int getLayout() {
        return R.layout.activity_sp2;
    }

    @Override
    public BasePresenter getPresenter() {
        return null;
    }
}
