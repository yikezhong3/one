package com.boreas.quarterhour.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.telecom.Call;
import android.util.Log;
import android.view.View;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.base.BaseFragment;
import com.boreas.quarterhour.base.BasePresenter;
import com.boreas.quarterhour.model.CrossTalkBean;
import com.boreas.quarterhour.presneter.CarousePresenter;
import com.boreas.quarterhour.view.CrossTalkView;
import com.boreas.quarterhour.view.adapter.CrossTalkAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 2018/1/19.
 */

public class CrossTalkFragment extends BaseFragment implements CrossTalkView {
    private CarousePresenter presenter;

    private List<CrossTalkBean.DataBean> list = new ArrayList<>();;
    private XRecyclerView dz_xrecycler;
    private CrossTalkAdapter crossTalkAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_dz;
    }

    @Override
    protected void initDagger() {
    }

    @Override
    protected void init() {
        presenter = new CarousePresenter(this);
        presenter.getLbData();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        dz_xrecycler.setLayoutManager(manager);
    }

    @Override
    protected void initView(View view) {
        dz_xrecycler = view.findViewById(R.id.dz_xrecycler);
    }



    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    public void success(CrossTalkBean crossTalkBean) {
        list= crossTalkBean.getData();
        crossTalkAdapter = new CrossTalkAdapter(getActivity(), list);
        Log.i("===========", crossTalkBean.getData().toString());
        dz_xrecycler.setAdapter(crossTalkAdapter);
    }

    @Override
    public void fail(Exception e) {

    }
}
