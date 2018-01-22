package com.boreas.quarterhour.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.base.BaseFragment;
import com.boreas.quarterhour.base.BasePresenter;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Dell on 2018/1/19.
 */

public class TJFragment extends BaseFragment {
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager viewPager;
    List<String> titlearray;
    List<Fragment> list;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tj;
    }

    @Override
    protected void initDagger() {

    }

    @Override
    protected void init() {

    }

    @Override
    protected void initView(View view) {

    }



    @Override
    protected BasePresenter getPresenter() {
        return null;
    }




}
