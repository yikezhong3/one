package com.boreas.quarterhour.fragment.tj;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.adapter.TJAdapter;
import com.boreas.quarterhour.base.BaseFragment;
import com.boreas.quarterhour.base.BasePresenter;
import com.boreas.quarterhour.model.LBModel;
import com.boreas.quarterhour.mvp.presenter.RMPresenter;
import com.boreas.quarterhour.mvp.view.RMView;
import com.boreas.quarterhour.utils.MyItemDecoration;

/**
 * Created by 123 on 2018/1/22.
 */

public class RMFragment extends BaseFragment implements RMView {

    private RecyclerView recyclerView;
    private TJAdapter adapter;
    private RMPresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tj_rm;
    }

    @Override
    protected void initDagger() {

    }

    @Override
    protected void init() {
        presenter = new RMPresenter(this);
        presenter.getData();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL ));
        adapter = new TJAdapter(getActivity());
    }

    @Override
    protected void initView(View view) {
        recyclerView = view.findViewById(R.id.recycle_tj_rm);
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    public void onSuccess(LBModel model) {
        adapter.addData(model);
        recyclerView.setAdapter(adapter);
    }
}
