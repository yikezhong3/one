package com.boreas.quarterhour.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.model.LBModel;
import com.boreas.quarterhour.utils.MyImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 123 on 2018/1/22.
 */

public class TJAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements OnBannerListener {

    private int ONE = 0;
    private int TWO = 1;
    private Context context;
    private List<String> lbModels;
    private List<TextView> textViews = new ArrayList<>();

    public TJAdapter(Context context) {
        this.context = context;
    }

    public void addData(LBModel model) {
        if (lbModels == null) {
            lbModels = new ArrayList<>();
        }
        for (LBModel.DataBean bean : model.getData()) {
            lbModels.add(bean.getIcon());
        }
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ONE) {
            return new ViewHolder1(LayoutInflater.from(context).inflate(R.layout.fragment_tj_lb_item, parent, false));
        } else {
            return new ViewHolder2(LayoutInflater.from(context).inflate(R.layout.fragment_tj_item, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder1) {
            ViewHolder1 viewHolder = (ViewHolder1) holder;
            //设置内置样式，共有六种
            viewHolder.banner.setImageLoader(new MyImageLoader());
            viewHolder.banner.setImages(lbModels);
            viewHolder.banner.setDelayTime(2000);
            viewHolder.banner.isAutoPlay(true);
            viewHolder.banner.setIndicatorGravity(BannerConfig.CENTER);
            viewHolder.banner.setOnBannerListener(this);
            viewHolder.banner.start();
        } else if (holder instanceof ViewHolder2) {
            ViewHolder2 viewHolder2 = (ViewHolder2) holder;
            viewHolder2.recycleTjItem.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            viewHolder2.recycleTjItem.setAdapter(new TJitemAdapter(context));
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ONE;
        } else {
            return TWO;
        }
    }

    //轮播图监听
    @Override
    public void OnBannerClick(int position) {
        Toast.makeText(context, "第" + position + 1 + "张", Toast.LENGTH_SHORT).show();
    }

    static class ViewHolder1 extends RecyclerView.ViewHolder {
        @BindView(R.id.banner)
        Banner banner;

        public ViewHolder1(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class ViewHolder2 extends RecyclerView.ViewHolder {
        @BindView(R.id.recycle_tj_item)
        RecyclerView recycleTjItem;

        public ViewHolder2(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class TJitemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private Context context;

        public TJitemAdapter(Context context) {
            this.context = context;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new TJitemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_tj, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof TJitemViewHolder){
                TJitemViewHolder viewHolder = (TJitemViewHolder) holder;

            }
        }

        @Override
        public int getItemCount() {
            return 0;
        }

        class TJitemViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.userHeadImage)
            ImageView userHeadImage;
            @BindView(R.id.nickname)
            TextView nickname;
            @BindView(R.id.createTime)
            TextView createTime;
            @BindView(R.id.pinbi)
            ImageView pinbi;
            @BindView(R.id.lianjie)
            ImageView lianjie;
            @BindView(R.id.jubao)
            ImageView jubao;
            @BindView(R.id.caozuoImage)
            ImageView caozuoImage;
            @BindView(R.id.title)
            TextView title;
            @BindView(R.id.repin1)
            TextView repin1;
            @BindView(R.id.repin2)
            TextView repin2;
            public TJitemViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }
}
