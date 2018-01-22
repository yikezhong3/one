package com.boreas.quarterhour;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.boreas.quarterhour.base.BaseActivity;
import com.boreas.quarterhour.base.BasePresenter;
import com.boreas.quarterhour.fragment.DZFragment;
import com.boreas.quarterhour.fragment.QTFragment;
import com.boreas.quarterhour.fragment.SPFragment;
import com.boreas.quarterhour.fragment.TJFragment;
import com.hjm.bottomtabbar.BottomTabBar;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity{

    @BindView(R.id.bottomBar)
    BottomTabBar bottomBar;
    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.name)
    TextView Title;
    @BindView(R.id.sou_s)
    LinearLayout souS;
    private SlidingMenu menu;

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
        // configure the SlidingMenu
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.color.colorAccent);
        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        /**
         * SLIDING_WINDOW will include the Title/ActionBar in the content
         * section of the SlidingMenu, while SLIDING_CONTENT does not.
         */
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //为侧滑菜单设置布局
        menu.setMenu(getLeftMenu());
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.toggle();
            }
        });
    }

    public View getLeftMenu() {
        //从主布局文件绑定的Activity调用另一个布局文件必须调用LayoutInflater
        LayoutInflater inflater = getLayoutInflater();
        //得到menu的View
        View v = inflater.inflate(R.layout.leftmenu, null);
        ListView listview = (ListView) v.findViewById(R.id.listView1);
        listview.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, getData()));
      listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              Toast.makeText(MainActivity.this,"点击了"+position,Toast.LENGTH_SHORT).show();
          }
      });
        return v;
    }
    private List<String> getData() {

        List<String> data = new ArrayList<String>();
        data.add("测试数据1");
        data.add("测试数据2");
        data.add("测试数据3");
        data.add("测试数据4");
        return data;
    }
}
