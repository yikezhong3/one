package com.boreas.quarterhour.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.base.BaseActivity;
import com.boreas.quarterhour.base.BasePresenter;
import com.boreas.quarterhour.model.UserDetailBean;
import com.boreas.quarterhour.presneter.UserDatilsPresenter;
import com.boreas.quarterhour.view.adapter.UserDetailsAdapter;
import com.boreas.quarterhour.view.myapp.UserDatilsView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserDetailsActivity extends BaseActivity implements UserDatilsView {

    @BindView(R.id.userDetailRecycle)
    RecyclerView userDetailRecycle;
    private UserDatilsPresenter presenter;
    private Map<String, String> map;
    private int page = 0;
    private UserDetailsAdapter adapter;

    @Override
    protected void initDagger() {

    }

    @Override
    protected void initView() {
        map = new HashMap<>();
        String uid = getIntent().getStringExtra("uid");
        Log.d("UserDetailsActi--uid ==",uid);
        map.put("uid", uid);
        map.put("page", page + "");
        map.put("source", "android");
        map.put("appVersion", "101");
        String id = getIntent().getStringExtra("id");

        if (uid != null && !"".equals(uid)) {
            presenter = new UserDatilsPresenter(this);
            presenter.getData(map);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this){
                @Override
                public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                    return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                }
            };
            userDetailRecycle.setLayoutManager(layoutManager);
            adapter = new UserDetailsAdapter(this,id);
            userDetailRecycle.setAdapter(adapter);
        }
    }

    @Override
    public int getLayout() {
        return R.layout.activity_user_details;
    }

    @Override
    public BasePresenter getPresenter() {
        return null;
    }

    @Override
    public void onSuccess(UserDetailBean bean) {
        adapter.addData(bean);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
