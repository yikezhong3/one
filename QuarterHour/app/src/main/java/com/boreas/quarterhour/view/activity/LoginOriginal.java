package com.boreas.quarterhour.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.base.BaseActivity;
import com.boreas.quarterhour.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginOriginal extends BaseActivity {


    @BindView(R.id.callback)
    ImageView callback;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.lgoin)
    Button lgoin;
    @BindView(R.id.gorget_password)
    TextView gorgetPassword;
    @BindView(R.id.tourist)
    TextView tourist;

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
        return R.layout.activity_login_original;
    }

    @Override
    public BasePresenter getPresenter() {
        return null;
    }

    @OnClick({R.id.callback, R.id.register, R.id.lgoin, R.id.gorget_password, R.id.tourist})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.callback:
                finish();
                break;
            case R.id.register:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            case R.id.lgoin:
                break;
            case R.id.gorget_password:
                startActivity(new Intent(this,ForgetActivity.class));
                break;
            case R.id.tourist:
                break;
        }
    }
}