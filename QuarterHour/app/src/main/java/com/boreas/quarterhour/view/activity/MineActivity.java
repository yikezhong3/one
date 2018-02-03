package com.boreas.quarterhour.view.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.view.fragment.Tab1Fragment;
import com.boreas.quarterhour.view.fragment.Tab2Fragment;

import java.util.ArrayList;
import java.util.List;

public class MineActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> list;
    private MyAdapter adapter;
    private
    String[] titles = {"本地作品","已上传"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        //实例化
        TextView textView = (TextView) findViewById(R.id.title).findViewById(R.id.callback);
        TextView title = (TextView) findViewById(R.id.title).findViewById(R.id.title1);
        textView.setText("<返回");
        title.setText("我的作品");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
//页面，数据源

        list = new ArrayList<>();
        list.add(new Tab1Fragment());
        list.add(new Tab2Fragment());
//ViewPager的适配器

        adapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

//绑定

        tabLayout.setupWithViewPager(viewPager);

    }

    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);

        }

        @Override

        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override

        public int getCount()
        {
            return list.size();
        }

//重写这个方法，将设置每个Tab的标题

        @Override

        public CharSequence getPageTitle(int position) {
            return titles[position];
        }  }  }
