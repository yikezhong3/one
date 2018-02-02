package com.boreas.quarterhour.base;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.view.WindowManager;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.utils.SlidingLayout;
import com.boreas.quarterhour.view.activity.MainActivity;
import com.jaeger.library.StatusBarUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Dell on 2018/1/19.
 */

public abstract class BaseActivity  <V , P extends  BasePresenter> extends AppCompatActivity{

    private  P presenter;
    private Unbinder bind;
   boolean isSwitchOn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        //设置颜色
        StatusBarUtil.setColor(this, Color.BLUE );
        //ButterKnife绑定
        bind = ButterKnife.bind(this);

        //沉浸式
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }

        initDagger();
        initView();
        presenter = getPresenter();
        if(presenter!= null){
            presenter.attachView((V)this);
        }
        if (enableSliding()) {
            SlidingLayout rootView = new SlidingLayout(this);
            rootView.bindActivity(this);
        }


    }

    protected boolean enableSliding() {
        return true;
    }
    protected abstract void initDagger();

    protected abstract void initView();

    public abstract  int getLayout();

    public abstract  P getPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            //清空订阅管理器
            presenter.removeCompositeDisposable();
            //解除p与v的关联
            presenter.detachView();
        }
        bind.unbind();
    }

}
