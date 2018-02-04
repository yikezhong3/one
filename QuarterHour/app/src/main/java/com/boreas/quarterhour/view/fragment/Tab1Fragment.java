package com.boreas.quarterhour.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.model.BendiBean;
import com.boreas.quarterhour.model.CollectBean;
import com.boreas.quarterhour.model.api.Api;
import com.boreas.quarterhour.model.api.ApiService;
import com.boreas.quarterhour.utils.GridSpacingItemDecoration;
import com.boreas.quarterhour.utils.MyOnItemClickListener;
import com.boreas.quarterhour.view.activity.CollectActivity;
import com.boreas.quarterhour.view.activity.ImageShowActivity;
import com.boreas.quarterhour.view.adapter.MyRecyclerAdapter2;
import com.boreas.quarterhour.view.adapter.MyRecyclerAdapter4;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dream on 2018/2/3.
 */

public class Tab1Fragment extends Fragment {
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_f1,null);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new GridLayoutManager/(getActivity(),3));
//        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, getResources().getDimensionPixelSize(R.dimen.divider_height), true));
        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.wodezuopin)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Flowable<BendiBean> loginSuccess = apiService.getBendi();
        loginSuccess.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BendiBean>() {
                    @Override
                    public void onNext(final BendiBean bendiBean) {
                        List<BendiBean.NewslistBean> newslist = bendiBean.getNewslist();
                        MyRecyclerAdapter4 myRecyclerAdapter = new MyRecyclerAdapter4(getActivity(),bendiBean.getNewslist());
                        recyclerView.setAdapter( myRecyclerAdapter);
                         /*点击事件*/
                        myRecyclerAdapter.setOnItemClickListener(new MyOnItemClickListener() {
                            @Override
                            public void OnItemClickListener(View view, int position) {
                                Toast.makeText(getActivity(), "触摸任意位置退出", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getActivity(), ImageShowActivity.class);
                                intent.putExtra("url",bendiBean.getNewslist().get(position).getPicUrl());
                                startActivity(intent);
                            }
                        });
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return view;
    }
}
