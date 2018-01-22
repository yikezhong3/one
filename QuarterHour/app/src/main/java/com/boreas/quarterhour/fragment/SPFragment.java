package com.boreas.quarterhour.fragment;

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
    protected void initView() {
        tv.setText("1233333333333");

    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }
}
