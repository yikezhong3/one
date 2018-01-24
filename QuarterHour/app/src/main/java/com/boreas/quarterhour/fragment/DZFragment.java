package com.boreas.quarterhour.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.adapter.DzAdapter;
import com.boreas.quarterhour.base.BaseFragment;
import com.boreas.quarterhour.base.BasePresenter;
import com.boreas.quarterhour.model.DZBean;
import com.boreas.quarterhour.mvp.presenter.LBPresenter;
import com.boreas.quarterhour.mvp.view.DZView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 2018/1/19.
 */

public class DZFragment extends BaseFragment implements DZView{
    private LBPresenter presenter;
    private DzAdapter dzAdapter;
    private List<DZBean.DataBean> list = new ArrayList<>();;
    private XRecyclerView dz_xrecycler;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_dz;
    }

    @Override
    protected void initDagger() {

    }

    @Override
    protected void init() {
        presenter = new LBPresenter(this);
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
    public void success(DZBean dzBean) {
        list=dzBean.getData();
        dzAdapter = new DzAdapter(getActivity(),list);
        Log.i("===========",dzBean.getData().toString());
        dz_xrecycler.setAdapter(dzAdapter);
    }

    @Override
    public void fail(Exception e) {

    }
}
