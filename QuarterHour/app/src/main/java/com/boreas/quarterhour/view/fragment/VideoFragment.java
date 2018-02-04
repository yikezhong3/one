package com.boreas.quarterhour.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.base.BaseFragment;
import com.boreas.quarterhour.base.BasePresenter;
import com.boreas.quarterhour.view.fragment.Video.SPRMFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 2018/1/19.
 */

public class VideoFragment extends BaseFragment {

    //注册
    //https://www.zhaoapi.cn/quarter/register?token=&source=android&appVersion=101&regType=0&mobile=18410340000&password=123456&userId=&gender=&nickname=&icon=
    //登录
    //https://www.zhaoapi.cn/user/login?token=&source=android&appVersion=101&mobile=18410340000&password=123456


    List<String> list = new ArrayList<>();
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sp;
    }

    @Override
    protected void initDagger() {
    }

    @Override
    protected void init() {

        list.add("热门");
        list.add("附近");

        viewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }

            @Override
            public Fragment getItem(int position) {
                SPRMFragment videohotFragment = new SPRMFragment();
                Bundle bundle = new Bundle();
                if (list.get(position).equals("热门")){
                    //不行的话就用这行转码,再传过去就能使用了
                    //String s = URLEncoder.encode("福利");
                    bundle.putString("name" , "热门");
                }else if (list.get(position).equals("附近")){
                    bundle.putString("name" , "附近");
                }
                videohotFragment.setArguments(bundle);
                return videohotFragment;
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        //tablayout要与viewpager关联
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    protected void initView(View view) {
        tabLayout = view.findViewById(R.id.video_tablayout);
        viewPager = view.findViewById(R.id.video_viewpager);
    }


    @Override
    protected BasePresenter getPresenter() {
        return null;
    }
}
