package com.boreas.quarterhour.view.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDelegate;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.base.BaseActivity;
import com.boreas.quarterhour.base.BasePresenter;
import com.boreas.quarterhour.model.AttentionBean;
import com.boreas.quarterhour.model.LoginSuccesBean;
import com.boreas.quarterhour.model.api.Api;
import com.boreas.quarterhour.model.api.ApiService;
import com.boreas.quarterhour.utils.CornersTransform;
import com.boreas.quarterhour.utils.DrawableSwitch;
import com.boreas.quarterhour.utils.MessageEvent;
import com.boreas.quarterhour.utils.SwitchView;
import com.boreas.quarterhour.view.SelectActivity;
import com.boreas.quarterhour.view.fragment.CrossTalkFragment;
import com.boreas.quarterhour.view.fragment.FunnyPicturesFragment;
import com.boreas.quarterhour.view.fragment.RecommendFragment;
import com.boreas.quarterhour.view.fragment.VideoFragment;
import com.bumptech.glide.Glide;
import com.hjm.bottomtabbar.BottomTabBar;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends BaseActivity{

    @BindView(R.id.bottomBar)
    BottomTabBar bottomBar;
    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.name)
    TextView Title;
    @BindView(R.id.sou_s)
    LinearLayout souS;
    @BindView(R.id.issue)
    ImageView is;
    private SlidingMenu menu;
    private long exitTime = 0;
    private String iconurl;
    private String username;
    private TextView username1;
    private ImageView touxiang;
    private DrawableSwitch drawableSwitch;
    private SwitchView switchView;
    private ImageView wenjianjia;
    private ImageView shezhi;



    @Subscribe(threadMode = ThreadMode.POSTING,sticky = true)
    public void ononMoonStickyEvent(MessageEvent messageEvent){
        iconurl = messageEvent.getIcon();
        username = messageEvent.getName();
     // Glide.with(this).load(iconurl).skipMemoryCache(true).into(icon);
       Glide.with(this).load(iconurl).transform(new CornersTransform(this,30)).into(icon);
        Glide.with(MainActivity.this).load(iconurl).error(R.mipmap.slid_touxiang).transform(new CornersTransform(MainActivity.this,30)).into(touxiang);
        username1.setText(""+ username);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    @Override
    protected void initDagger() {
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected boolean enableSliding() {
        return false;
    }
    @Override
    protected void initView() {


        bottomBar.init(getSupportFragmentManager())
                .setImgSize(50, 50)
                .setFontSize(15)
                .addTabItem("推荐", R.drawable.tuijian_select, R.drawable.tuijian_default, RecommendFragment.class)
                .addTabItem("段子", R.drawable.duanzi_select, R.drawable.duanzi_default, CrossTalkFragment.class)
                .addTabItem("视频", R.drawable.video_select, R.drawable.video_defaults, VideoFragment.class)
                .addTabItem("趣图", R.drawable.qutusdown, R.drawable.qutuno, FunnyPicturesFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                        if (name.equals("推荐")) {
                            Title.setText("推荐");
                            is.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(MainActivity.this,"推荐",Toast.LENGTH_SHORT).show();
                                }
                            });
                        } else if (name.equals("段子")) {
                            Title.setText("段子");
                            is.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(MainActivity.this,"段子",Toast.LENGTH_SHORT).show();
                                }
                            });
                        } else if(name.equals("视频")){
                            Title.setText("视频");
                            is.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(MainActivity.this,"视频",Toast.LENGTH_SHORT).show();
                                }
                            });
                        } else{
                            Title.setText("趣图");
                            is.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    startActivity(new Intent(MainActivity.this,PropertyActivity.class));
                                }
                            });
                        }
                    }
                });

            Sliding();
    }

    private void Sliding() {
        // configure the SlidingMenu
        EventBus.getDefault().register(MainActivity.this);
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        /*
         * SlidingMenu.TOUCHMODE_FULLSCREEN 全屏触摸有效
         * SlidingMenu.TOUCHMODE_MARGIN 拖拽边缘有效
         * SlidingMenu.TOUCHMODE_NONE 不响应触摸事件
         */
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
//        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.color.colorAccent);
        menu.attachToActivity(this,SlidingMenu.SLIDING_CONTENT,true);
        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        /**
         * SLIDING_WINDOW will include the Title/ActionBar in the content
         * section of the SlidingMenu, while SLIDING_CONTENT does not.
         */
        //为侧滑菜单设置布局
        menu.setMenu(getLeftMenu());
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.toggle();

            }
        });
        //开关的点击事件
        int mode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switchView.setOnStateChangedListener(new SwitchView.OnStateChangedListener() {
            @Override
            public void toggleToOn(SwitchView view) {
                switchView.setOpened(true);
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                recreate();
            }

            @Override
            public void toggleToOff(SwitchView view) {
                switchView.setOpened(false);
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                recreate();
            }
        });

        //文件夹点击事件
        wenjianjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(MainActivity.this,MineActivity.class));
            }
        });

        //设置的点击事件
        shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SettingActivity.class));
            }
        });

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



    public View getLeftMenu() {
         final int[] imagesId={R.mipmap.slid_aixin,R.mipmap.slid_wujaioxiang,R.mipmap.slid_select,R.mipmap.slid_lingdang};
         final String[] names={"我的关注","我的收藏","搜索好友","消息通知"};
        final int[] contents={R.mipmap.slid_more,R.mipmap.slid_more,R.mipmap.slid_more,R.mipmap.slid_more};
        //从主布局文件绑定的Activity调用另一个布局文件必须调用LayoutInflater
        LayoutInflater inflater = getLayoutInflater();
        //得到menu的View
        View v = inflater.inflate(R.layout.leftmenu, null);
        ListView listview = (ListView) v.findViewById(R.id.listView1);

        switchView = v.findViewById(R.id.drawableSwitch);
        touxiang = v.findViewById(R.id.slid_touxiang);
        username1 = v.findViewById(R.id.username);
        wenjianjia = v.findViewById(R.id.wenjianjia);
        shezhi = v.findViewById(R.id.shezhi);


        //头像的点击事件
        touxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginHomePage.class));
            }
        });
        BaseAdapter adapter = new BaseAdapter() {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // TODO 自动生成的方法存根
                @SuppressLint("ViewHolder") View layout=View.inflate(MainActivity.this, R.layout.slid_custom_list, null);
                ImageView face = (ImageView)layout.findViewById(R.id.face);
                TextView name =(TextView)layout.findViewById(R.id.name);
                ImageView mark = (ImageView)layout.findViewById(R.id.mark);

                face.setImageResource(imagesId[position]);
                name.setText(names[position]);
                mark.setImageResource(contents[position]);

                return layout;
            }

            @Override
            public long getItemId(int position) {
                // TODO 自动生成的方法存根
                return position;
            }

            @Override
            public Object getItem(int position) {
                // TODO 自动生成的方法存根
                return names[position];
            }

            @Override
            public int getCount() {
                // TODO 自动生成的方法存根
                return names.length;
            }
        };///new BaseAdapter()
      listview.setAdapter(adapter);
      listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              if (position==0){
                  startActivity(new Intent(MainActivity.this,AttentionActivity.class));
              }else if (position==1){
                  startActivity(new Intent(MainActivity.this,CollectActivity.class));
              }else if (position==2){
                  startActivity(new Intent(MainActivity.this,SelectActivity.class));
              }else{
                  Toast.makeText(MainActivity.this,"敬请期待",Toast.LENGTH_SHORT).show();
              }
          }
      });
        return v;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(MainActivity.this);
    }

}
