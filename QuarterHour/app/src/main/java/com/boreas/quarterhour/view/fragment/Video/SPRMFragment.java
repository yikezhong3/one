package com.boreas.quarterhour.view.fragment.Video;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.base.BaseFragment;
import com.boreas.quarterhour.model.VideoHotBean;
import com.boreas.quarterhour.model.VideoHotLike;
import com.boreas.quarterhour.presneter.VideoHotPresenter;
import com.boreas.quarterhour.utils.dagger.DaggerMyComponent;
import com.boreas.quarterhour.view.adapter.VideoHotAdapter;
import com.boreas.quarterhour.view.fragment.Video.view.VideoHotView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Lonely on 2018/1/25.
 */

public class SPRMFragment extends BaseFragment<VideoHotView , VideoHotPresenter> implements VideoHotView {

    private XRecyclerView xRecyclerView;

    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    @Inject
    VideoHotPresenter videoHotPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video_hot;
    }

    @Override
    protected void initDagger() {
        DaggerMyComponent.create().injectsp(this);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initView(View view) {
        videoHotPresenter.login();

        xRecyclerView = view.findViewById(R.id.video_hot_xrecyclerview);
    }

    @Override
    protected VideoHotPresenter getPresenter() {
        return videoHotPresenter;
    }

    @Override
    public void success(VideoHotBean bean) {
        System.out.println("XXXX" + bean.toString());
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        xRecyclerView.addItemDecoration(new SpaceItemDecoration(20)); //设置间隔

        List<VideoHotBean.DataBean> list = bean.getData();
        VideoHotAdapter videoHotAdapter = new VideoHotAdapter(getActivity(), list);
        xRecyclerView.setAdapter(videoHotAdapter);
    }

    public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        private int space;
        public SpaceItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;
            if (parent.getChildPosition(view) == 0) {
                outRect.top = space;
            }
        }
    }

}
