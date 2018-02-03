package com.boreas.quarterhour.view.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.model.CollectBean;
import com.boreas.quarterhour.model.api.Api;
import com.boreas.quarterhour.model.api.ApiService;
import com.boreas.quarterhour.view.adapter.MyRecyclerAdapter2;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CollectActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        TextView textView = (TextView) findViewById(R.id.title).findViewById(R.id.callback);
        TextView title = (TextView) findViewById(R.id.title).findViewById(R.id.title1);
        textView.setText("<返回");
        title.setText("我的收藏");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        sp = getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
            String token = sp.getString("token", null);
        getAttention(983,token,"android","1");




    }
    public void getAttention(int uid,String token,String source,String appVersion) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.LoginUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Flowable<CollectBean> loginSuccess = apiService.getCollect(uid, token,source,appVersion);
        loginSuccess.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<CollectBean>() {
                    @Override
                    public void onNext(CollectBean collectBean) {
                        List<CollectBean.DataBean> data = collectBean.getData();
                        MyRecyclerAdapter2 myRecyclerAdapter = new MyRecyclerAdapter2(CollectActivity.this,collectBean);
                        recyclerView.setAdapter( myRecyclerAdapter);

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
