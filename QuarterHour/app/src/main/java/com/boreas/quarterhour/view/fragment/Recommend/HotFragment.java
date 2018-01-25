package com.boreas.quarterhour.view.fragment.Recommend;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.view.adapter.RecommendAdapter;
import com.boreas.quarterhour.base.BaseFragment;
import com.boreas.quarterhour.base.BasePresenter;
import com.boreas.quarterhour.model.CarouselModel;
import com.boreas.quarterhour.presneter.HotPresenter;
import com.boreas.quarterhour.view.HotView;

/**
 * Created by 123 on 2018/1/22.
 */

public class HotFragment extends BaseFragment implements HotView {

    private RecyclerView recyclerView;
    private RecommendAdapter adapter;
    private HotPresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tj_rm;
    }

    @Override
    protected void initDagger() {

    }

    @Override
    protected void init() {
        presenter = new HotPresenter(this);
        presenter.getData();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL ));
        adapter = new RecommendAdapter(getActivity());
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
    public void onSuccess(CarouselModel model) {
        adapter.addData(model);
        recyclerView.setAdapter(adapter);
    }
}
