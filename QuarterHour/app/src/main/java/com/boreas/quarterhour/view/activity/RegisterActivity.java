package com.boreas.quarterhour.view.activity;

import android.content.Intent;
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
import com.boreas.quarterhour.model.RegisterBean;
import com.boreas.quarterhour.model.api.Api;
import com.boreas.quarterhour.model.api.ApiService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.callback)
    ImageView callback;
    @BindView(R.id.existing_account)
    TextView existingAccount;
    @BindView(R.id.register)
    Button register;
    @BindView(R.id.tourist)
    TextView tourist;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;

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
        return R.layout.activity_register;
    }

    @Override
    public BasePresenter getPresenter() {
        return null;
    }

    @OnClick({R.id.callback, R.id.existing_account, R.id.register, R.id.tourist})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.callback:
                finish();
                break;
            case R.id.existing_account:
                finish();
                break;
            case R.id.register:
                String name = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Api.LoginUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();
                ApiService apiService = retrofit.create(ApiService.class);
                Flowable<RegisterBean> registerSuccess = apiService.getRegisterSuccess(0, name, pass);
                registerSuccess.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSubscriber<RegisterBean>() {
                            @Override
                            public void onNext(RegisterBean registerBean) {
                                String code = registerBean.getCode();
                                if (code.equals("0")){
                                    Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                                    finish();
                                }else if (code.equals("1")){
                                    Toast.makeText(RegisterActivity.this,"用户已注册",Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(RegisterActivity.this,"注册失败",Toast.LENGTH_SHORT).show();

                                }
                            }

                            @Override
                            public void onError(Throwable t) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });


                break;
            case R.id.tourist:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}

