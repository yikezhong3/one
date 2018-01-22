package com.boreas.quarterhour.fragment;

import android.view.View;
import android.widget.TextView;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.base.BaseFragment;
import com.boreas.quarterhour.base.BasePresenter;

import butterknife.BindView;

/**
 * Created by Dell on 2018/1/19.
 */

public class SPFragment extends BaseFragment {
    @BindView(R.id.tv)
    TextView tv;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sp;
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
