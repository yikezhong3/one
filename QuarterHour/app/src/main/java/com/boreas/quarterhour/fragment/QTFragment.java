package com.boreas.quarterhour.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.activity.Sp2Activity;
import com.boreas.quarterhour.base.BaseFragment;
import com.boreas.quarterhour.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Dell on 2018/1/19.
 */

public class QTFragment extends BaseFragment {
    @BindView(R.id.btn)
    Button btn;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_pt;
    }

    @Override
    protected void initDagger() {

    }

    @Override
    protected void init() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Sp2Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initView(View view) {

    }


    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
