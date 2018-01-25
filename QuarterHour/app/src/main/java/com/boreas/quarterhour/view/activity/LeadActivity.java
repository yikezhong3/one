package com.boreas.quarterhour.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.base.BaseActivity;
import com.boreas.quarterhour.utils.dagger.DaggerMyComponent;
import com.boreas.quarterhour.presneter.SplashPresenter;
import com.boreas.quarterhour.view.SplashView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import javax.inject.Inject;

import butterknife.BindView;

public class LeadActivity extends BaseActivity<SplashView, SplashPresenter> implements SplashView{


    @BindView(R.id.iv_splash)
    ImageView ivSplash;
    @BindView(R.id.tv_copyright)
    TextView tvCopyright;
    public Handler mHandler = new Handler();
    @Inject
    SplashPresenter presenter;
    private RequestManager with;

    @Override
    public int getLayout() {
        return R.layout.activity_lead;
    }

    @Override
    protected void initDagger() {
        DaggerMyComponent.create().inject(this);
    }

    @Override
    protected boolean enableSliding() {
        return false;
    }
    @Override
    protected void initView() {
        presenter.getdata();
        with = Glide.with(LeadActivity.this);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setClass(LeadActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }

    @Override
    public SplashPresenter getPresenter() {
        return presenter;
    }


    @Override
    public void onSuccess(final String data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                with.load(data).into(ivSplash);
            }
        });


    }
}
