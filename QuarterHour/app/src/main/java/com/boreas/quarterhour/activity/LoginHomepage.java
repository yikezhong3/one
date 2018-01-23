package com.boreas.quarterhour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.boreas.quarterhour.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginHomepage extends AppCompatActivity {

    @BindView(R.id.login_wx)
    ImageView loginWx;
    @BindView(R.id.login_qq)
    ImageView loginQq;
    @BindView(R.id.login_other)
    TextView loginOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_homepage);
        ButterKnife.bind(this);
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
