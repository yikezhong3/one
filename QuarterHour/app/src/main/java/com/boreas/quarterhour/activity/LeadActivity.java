package com.boreas.quarterhour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.boreas.quarterhour.MainActivity;
import com.boreas.quarterhour.R;
import com.boreas.quarterhour.base.BaseActivity;
import com.boreas.quarterhour.dagger.DaggerMyComponent;
import com.boreas.quarterhour.mvp.presenter.SplashPresenter;
import com.boreas.quarterhour.mvp.view.SplashView;
import com.bumptech.glide.Glide;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeadActivity extends BaseActivity<SplashView, SplashPresenter> implements SplashView{


    @BindView(R.id.iv_splash)
    ImageView ivSplash;
    @BindView(R.id.tv_copyright)
    TextView tvCopyright;
    public Handler mHandler = new Handler();
    @Inject
    SplashPresenter presenter;

    @Override
    public int getLayout() {
        return R.layout.activity_lead;
    }

    @Override
    protected void initDagger() {
        DaggerMyComponent.create().inject(this);
    }

    @Override
    protected void initView() {
        presenter.getdata();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setClass(LeadActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }


    @Override
    public SplashPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onSuccess(final String data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Glide.with(LeadActivity.this).load(data).into(ivSplash);
            }
        });
    }
}
