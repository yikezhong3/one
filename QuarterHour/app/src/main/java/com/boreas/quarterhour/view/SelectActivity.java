package com.boreas.quarterhour.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.model.SelectBean;
import com.boreas.quarterhour.model.api.Api;
import com.boreas.quarterhour.model.api.ApiService;
import com.boreas.quarterhour.view.adapter.MyRecyclerAdapter3;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import scut.carson_ho.searchview.ICallBack;
import scut.carson_ho.searchview.SearchView;
import scut.carson_ho.searchview.bCallBack;

public class SelectActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    // 1. 初始化搜索框变量
    private SearchView searchView;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        sp = getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String token = sp.getString("token", null);
        getSelect();
        // 3. 绑定组件
        // 3. 绑定组件
        searchView = (SearchView) findViewById(R.id.search_view);

        // 4. 设置点击键盘上的搜索按键后的操作（通过回调接口）
        // 参数 = 搜索框输入的内容
        searchView.setOnClickSearch(new ICallBack() {
            @Override
            public void SearchAciton(String string) {
                System.out.println("我收到了" + string);
            }
        });

        // 5. 设置点击返回按键后的操作（通过回调接口）
        searchView.setOnClickBack(new bCallBack() {
            @Override
            public void BackAciton() {
                finish();
            }
        });



    }
    public void getSelect() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.LoginUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Flowable<SelectBean> loginSuccess = apiService.getSelect();
        loginSuccess.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<SelectBean>() {
                    @Override
                    public void onNext(SelectBean selectBean) {

                        MyRecyclerAdapter3 myRecyclerAdapter = new MyRecyclerAdapter3(SelectActivity.this,selectBean.getData());
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