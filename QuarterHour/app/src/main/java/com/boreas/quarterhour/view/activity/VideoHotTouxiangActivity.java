package com.boreas.quarterhour.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.base.BaseActivity;
import com.boreas.quarterhour.base.BasePresenter;
import com.boreas.quarterhour.model.UserDetailBean;
import com.boreas.quarterhour.presneter.UserDatilsPresenter;
import com.boreas.quarterhour.view.adapter.UserDetailsAdapter;
import com.boreas.quarterhour.view.adapter.VideoHotTouxiangAdapter;
import com.boreas.quarterhour.view.myapp.UserDatilsView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoHotTouxiangActivity extends BaseActivity implements UserDatilsView {

    @BindView(R.id.videoDetailRecycle)
    RecyclerView userDetailRecycle;
//    @BindView(R.id.userDetailFanhui)
//    TextView textView;
    private UserDatilsPresenter presenter;
    private Map<String, String> map;
    private int page = 0;
    private VideoHotTouxiangAdapter adapter;
    private String tx;
    private String uid;
    private String title;

    @Override
    protected void initDagger() {

    }

    @Override
    protected void initView() {
        map = new HashMap<>();
        uid = getIntent().getStringExtra("uid");
        tx = getIntent().getStringExtra("tx");
        title = getIntent().getStringExtra("title");
        Log.d("VideoHotTouxi--uid ==", uid);
        map.put("uid", uid);
        map.put("page", page + "");
        map.put("source", "android");
        map.put("appVersion", "101");
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
            adapter = new VideoHotTouxiangAdapter(this);
            userDetailRecycle.setAdapter(adapter);
        }
    }

    @Override
    public int getLayout() {
        return R.layout.activity_video_hot_touxiang;
    }

    @Override
    public BasePresenter getPresenter() {
        return null;
    }

    @Override
    public void onSuccess(UserDetailBean bean) {
        adapter.addData(title , tx , bean);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
