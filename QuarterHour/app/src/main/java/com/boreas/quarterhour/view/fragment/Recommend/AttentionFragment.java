package com.boreas.quarterhour.view.fragment.Recommend;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.base.BaseFragment;
import com.boreas.quarterhour.base.BasePresenter;
import com.boreas.quarterhour.model.CarouselModel;
import com.boreas.quarterhour.model.RMBean;
import com.boreas.quarterhour.presneter.HotPresenter;
import com.boreas.quarterhour.view.HotView;
import com.boreas.quarterhour.view.adapter.RecommendAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 123 on 2018/1/22.
 */

public class AttentionFragment extends BaseFragment implements HotView {

    private RecyclerView recyclerView;
    private RecommendAdapter adapter;
    private HotPresenter presenter;
    private int page = 0;
    private String token = "1";
    private Map<String, String> map;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tj_rm;
    }

    @Override
    protected void initDagger() {

    }

    @Override
    protected void init() {
        map = new HashMap<>();
        map.put("page", page+"");
        map.put("token", token+"");
        map.put("source","android");
        map.put("appVersion","101");
        presenter = new HotPresenter(this);
        presenter.getData();
        presenter.getRMdata(map);
        adapter = new RecommendAdapter(getActivity());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity()){
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams(){
                return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        };
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
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
    }

    @Override
    public void onSuccessTn(RMBean bean) {
        adapter.addRMdata(bean);
    }
}
