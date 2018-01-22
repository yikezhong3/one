package com.boreas.quarterhour.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.api.Api;
import com.boreas.quarterhour.api.ApiService;
import com.boreas.quarterhour.base.BaseFragment;
import com.boreas.quarterhour.base.BasePresenter;
import com.boreas.quarterhour.model.LBModel;
import com.boreas.quarterhour.utils.RetrofitClent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

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
