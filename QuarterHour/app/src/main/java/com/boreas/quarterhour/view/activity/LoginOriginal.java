package com.boreas.quarterhour.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.base.BaseActivity;
import com.boreas.quarterhour.base.BasePresenter;
import com.boreas.quarterhour.model.LoginSuccesBean;
import com.boreas.quarterhour.model.api.Api;
import com.boreas.quarterhour.presneter.LoginSuccessPresenter;
import com.boreas.quarterhour.view.LoginSuccesView;
import com.umeng.socialize.utils.Log;

import java.lang.reflect.Proxy;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginOriginal extends BaseActivity implements LoginSuccesView {


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
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.userpass)
    EditText userpass;
    private LoginSuccessPresenter loginSuccessPresenter;

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
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.lgoin:
                // 获取名字和密码
                String name = username.getText().toString().trim();
                String pass = userpass.getText().toString().trim();
                //发送请求
               loginSuccessPresenter = new LoginSuccessPresenter(this);
               loginSuccessPresenter.getLoginUrl(Api.LoginUrl, name, pass);
                break;
            case R.id.gorget_password:
                startActivity(new Intent(this, ForgetActivity.class));
                break;
            case R.id.tourist:
                Toast.makeText(this,"游客登录直接返回到主页面",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,MainActivity.class));
                break;
        }
    }

    @Override
    public void getData(LoginSuccesBean loginSuccesBean) {
        String code = loginSuccesBean.getCode();
        if (code.equals("0")) {
            int uid = loginSuccesBean.getData().getUid();
            String token = loginSuccesBean.getData().getToken();
            SharedPreferences sp = getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
            sp.edit().putString("token", token).putInt("uid", uid).commit();

            Toast.makeText(LoginOriginal.this, "登录成功", Toast.LENGTH_SHORT).show();
            int i = sp.getInt("uid", 0);
            Log.i("uid=======",i+"-----------------");
            System.out.println("i = " + i);
            Intent intent = new Intent(LoginOriginal.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(LoginOriginal.this, "登录失败", Toast.LENGTH_SHORT).show();
        }
    }
}