package com.boreas.quarterhour.view.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.base.BaseFragment;
import com.boreas.quarterhour.base.BasePresenter;
import com.boreas.quarterhour.utils.DataProvider;
import com.boreas.quarterhour.view.activity.PhotoBrowseActivity;
import com.boreas.quarterhour.view.adapter.ImageAdapter;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Dell on 2018/1/19.
 */

public class FunnyPicturesFragment extends BaseFragment {

    EasyRecyclerView recyclerView;
    ImageAdapter adapter;
    private Bundle mReenterState;
    ViewGroup parent;
    private FrameLayout frameLayout;

    @Override
    protected int getLayoutId() {

        return R.layout.fragment_pt;
    }

    @Override
    protected void initDagger() {

    }

    @Override
    protected void init() {
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter = new ImageAdapter(getActivity()));
        //加载动画
        recyclerView.showProgress();

        //添加边框
        SpaceDecoration itemDecoration = new SpaceDecoration((int) convertDpToPixel(8,getActivity()));
        itemDecoration.setPaddingEdgeSide(true);
        itemDecoration.setPaddingStart(true);
        itemDecoration.setPaddingHeaderFooter(false);
        recyclerView.addItemDecoration(itemDecoration);
        //更多加载
        adapter.setMore(R.layout.view_more, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                addData();
            }

            @Override
            public void onMoreClick() {

            }
        });

        //移除加载更多页脚
        //adapter.stopMore();
        //没有更多
        adapter.setNoMore(R.layout.view_nomore);

        //写刷新事件
        recyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.clear();
                        adapter.addAll(DataProvider.getPicStr());
                    }
                },1000);
            }
        });

        //点击事件
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                View imageView = parent.getChildAt(position);
                final ArrayList<String> pictureList = new ArrayList<>();
                pictureList.addAll(DataProvider.getPicStr());
                PhotoBrowseActivity.startWithElement(getActivity(), pictureList, position, imageView);
            }
        });


        setSharedElementCallback();
        addData();

    }


    private void setSharedElementCallback( ) {
        ActivityCompat.setExitSharedElementCallback(getActivity(), new SharedElementCallback() {
            @Override
            public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
                if (mReenterState!=null){
                    int index = mReenterState.getInt("index",0);
                    sharedElements.clear();
                    sharedElements.put("tansition_view",parent.getChildAt(index));
                    mReenterState = null;
                }
            }
        });
    }





    @Override
    protected void initView(View view) {
        recyclerView = view.findViewById(R.id.recy);
        parent = (ViewGroup) view.findViewById(R.id.container);
        frameLayout = view.findViewById(R.id.flayout);
    }


    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    private void addData(){
        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.addAll(DataProvider.getPicStr());
            }
        },1000);
    }

    public static float convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return px;
    }

}
