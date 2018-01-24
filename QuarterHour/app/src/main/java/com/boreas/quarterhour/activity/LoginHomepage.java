package com.boreas.quarterhour.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.base.BaseActivity;
import com.boreas.quarterhour.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginHomepage extends BaseActivity {

    @BindView(R.id.login_wx)
    ImageView loginWx;
    @BindView(R.id.login_qq)
    ImageView loginQq;
    @BindView(R.id.login_other)
    TextView loginOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected void initDagger() {

    }

    @Override
    protected void initView() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_login_homepage;
    }

    @Override
    public BasePresenter getPresenter() {
        return null;
    }

    @OnClick({R.id.login_wx, R.id.login_qq, R.id.login_other})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_wx:
                Toast.makeText(this,"wx登录",Toast.LENGTH_SHORT).show();
                break;
            case R.id.login_qq:
                Toast.makeText(this,"qq登录",Toast.LENGTH_SHORT).show();
                break;
            case R.id.login_other:
                startActivity(new Intent(this,LoginOriginal.class));
                break;
        }
    }
}

