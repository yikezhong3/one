package com.boreas.quarterhour;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.boreas.quarterhour.base.BaseActivity;
import com.boreas.quarterhour.base.BasePresenter;
import com.boreas.quarterhour.fragment.DZFragment;
import com.boreas.quarterhour.fragment.QTFragment;
import com.boreas.quarterhour.fragment.SPFragment;
import com.boreas.quarterhour.fragment.TJFragment;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {

    @BindView(R.id.bottomBar)
    BottomTabBar bottomBar;
    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.name)
    TextView Title;
    @BindView(R.id.sou_s)
    LinearLayout souS;
    @BindView(R.id.drawerlayout)
    DrawerLayout dl;
    @Override
    protected void initDagger() {
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        bottomBar.init(getSupportFragmentManager())
                .setImgSize(50, 50)
                .setFontSize(15)
                .addTabItem("推荐", R.drawable.tuijian_select, R.drawable.tuijian_default, TJFragment.class)
                .addTabItem("段子", R.drawable.duanzi_select, R.drawable.duanzi_default, DZFragment.class)
                .addTabItem("视频", R.drawable.video_select, R.drawable.video_defaults, SPFragment.class)
                .addTabItem("趣图", R.drawable.qutusdown, R.drawable.qutuno, QTFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                        if (name.equals("推荐")) {
                            Title.setText("推荐");
                        } else if (name.equals("段子")) {
                            Title.setText("段子");
                        } else if(name.equals("视频")){
                            Title.setText("视频");
                        } else{
                            Title.setText("趣图");
                        }
                    }
                });

        onSlidingClick();
    }

    //侧滑
    public void onSlidingClick() {

    }

    @Override
    public BasePresenter getPresenter() {
        return null;
    }

    /**
     * 点击事件
     *
     * @param view
     */
    public void toggleMenu(View view) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
