package com.boreas.quarterhour.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.base.BaseFragment;
import com.boreas.quarterhour.base.BasePresenter;
import com.boreas.quarterhour.fragment.tj.GZFragment;
import com.boreas.quarterhour.fragment.tj.RMFragment;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Dell on 2018/1/19.
 */

public class TJFragment extends BaseFragment {

    TabLayout tab_tj;
    ViewPager vp_tj;
    List<String> titlearray;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tj;
    }

    @Override
    protected void initDagger() {

    }

    @Override
    protected void init() {
        titlearray = Arrays.asList("热门","关注");

        vp_tj.setOffscreenPageLimit(titlearray.size());
        vp_tj.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {

            @Override
            public CharSequence getPageTitle(int position) {
                return titlearray.get(position);
            }

            @Override
            public Fragment getItem(int position) {
                if (titlearray.get(position).equals("热门")){
                    return new RMFragment();
                }else if (titlearray.get(position).equals("关注")){
                    return new GZFragment();
                }
                return null;
            }

            @Override
            public int getCount() {
                return titlearray.size();
            }
        });
        tab_tj.setupWithViewPager(vp_tj);
    }

    @Override
    protected void initView(View view) {
        tab_tj = view.findViewById(R.id.tab_tj);
        vp_tj = view.findViewById(R.id.vp_tj);
    }



    @Override
    protected BasePresenter getPresenter() {
        return null;
    }




}
