package com.boreas.quarterhour.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.base.BaseActivity;
import com.boreas.quarterhour.base.BasePresenter;
import com.boreas.quarterhour.utils.MessageEvent;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import org.greenrobot.eventbus.EventBus;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginHomePage extends BaseActivity {

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
                UMShareAPI.get(LoginHomePage.this).getPlatformInfo(LoginHomePage.this,
                                                             SHARE_MEDIA.QQ,umAuthListener);
                break;
            case R.id.login_other:
                startActivity(new Intent(this,LoginOriginal.class));
                break;
        }
    }
    //qq登录的回调方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
    //第三方登录的监听事件
    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //授权开始的回调
            startActivity(new Intent(LoginHomePage.this,MainActivity.class));

        }
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
          //获取头像和名字
            String icon = data.get("iconurl");
            String name =  data.get("screen_name");
            EventBus.getDefault().postSticky(new MessageEvent(icon,name));
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(LoginHomePage.this, "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText( LoginHomePage.this, "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };

}

