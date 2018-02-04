package com.boreas.quarterhour.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.model.CarouselModel;
import com.boreas.quarterhour.model.RMBean;
import com.boreas.quarterhour.utils.MyImageLoader;
import com.boreas.quarterhour.utils.ShowAnimUtil;
import com.boreas.quarterhour.view.activity.UserDetailsActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by 123 on 2018/1/22.
 */

public class RecommendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements OnBannerListener {

    private int ONE = 0;
    private int TWO = 1;
    private Context context;
    private List<String> lbModels;
    private List<TextView> textViews = new ArrayList<>();
    private List<RMBean.DataBean> rmLists;

    public RecommendAdapter(Context context) {
        this.context = context;
    }

    public void addData(CarouselModel model) {
        if (lbModels == null) {
            lbModels = new ArrayList<>();
        }
        for (CarouselModel.DataBean bean : model.getData()) {
            lbModels.add(bean.getIcon());
        }

        notifyDataSetChanged();
    }

    public void addRMdata(RMBean bean) {
        if (rmLists == null) {
            rmLists = new ArrayList<>();
        }
        for (RMBean.DataBean b : bean.getData()) {
            rmLists.add(b);
        }

        notifyDataSetChanged();

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ONE) {
            return new ViewHolder1(LayoutInflater.from(context).inflate(R.layout.fragment_tj_lb_item, null));
        } else {
            return new ViewHolder2(LayoutInflater.from(context).inflate(R.layout.fragment_tj_item, null));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (lbModels != null) {

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
                LinearLayoutManager layoutManager = new LinearLayoutManager(context) {
                    @Override
                    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    }
                };
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                viewHolder2.recycleTjItem.setLayoutManager(layoutManager);
                viewHolder2.recycleTjItem.setAdapter(new TJitemAdapter(context, rmLists));
            }
        }
    }

    @Override
    public int getItemCount() {
        return 2;
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
}

class TJitemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private Context context;
    private List<RMBean.DataBean> rmLists;
    //private static List<ImageView> imageViews = new ArrayList<>();
    //private static List<TextView> textViews = new ArrayList<>();
    private List<RMBean.DataBean.UserBean> userBeans = new ArrayList<>();
    private List<RMBean.DataBean.CommentsBean> commentsBeans = new ArrayList<>();
    private String uid = "";

    public TJitemAdapter(Context context, List<RMBean.DataBean> rmLists) {
        this.context = context;
        this.rmLists = rmLists;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TJitemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_tj, null, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        uid = rmLists.get(position).getUid()+"";
        userBeans.clear();
        commentsBeans.clear();
        userBeans.add(rmLists.get(position).getUser());
        commentsBeans.addAll(rmLists.get(position).getComments());
        String[] arrs = rmLists.get(position).getCreateTime().split("T");
        if (holder instanceof TJitemViewHolder) {
            final TJitemViewHolder viewHolder = (TJitemViewHolder) holder;

            viewHolder.imageViews = new ArrayList<>();
            viewHolder.textViews = new ArrayList<>();
            viewHolder.imageViews.add(viewHolder.warning);
            viewHolder.imageViews.add(viewHolder.timg);
            viewHolder.imageViews.add(viewHolder.banned);
            viewHolder.textViews.add(viewHolder.tvBanned);
            viewHolder.textViews.add(viewHolder.tvWarning);
            viewHolder.textViews.add(viewHolder.tvTimg);
            String url2 = "http://ic.snssdk.com/neihan/video/playback/?video_id=3037a89e9e3f44338e2c55e0927e43f7&quality=480p&line=0&is_gif=0&device_platform=.mp4";
            String url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
            viewHolder.videoplayer.setUp(url2,JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "哎呦我靠");
            new MyImageLoader().displayImage(context, url, viewHolder.videoplayer.thumbImageView);
            viewHolder.videoplayer.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);

            viewHolder.incMenu.bringToFront();

            viewHolder.imgPublish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!rmLists.get(position).isMenuOpen()) {
                        //showOpenAnim(viewHolder, 140);
                        new ShowAnimUtil().showOpenAnim(context, viewHolder, viewHolder.imageViews, viewHolder.textViews, viewHolder.imgPublish, 140);
                        viewHolder.imgPublish.setImageResource(R.mipmap.ico_minus);
                        rmLists.get(position).setMenuOpen(true);
                    } else {
                        //showCloseAnim(viewHolder, 140);
                        new ShowAnimUtil().showCloseAnim(context, viewHolder, viewHolder.imageViews, viewHolder.textViews, viewHolder.imgPublish, 140);
                        viewHolder.imgPublish.setImageResource(R.mipmap.ico_plus);
                        rmLists.get(position).setMenuOpen(false);
                    }
                }
            });
            viewHolder.timg.setOnClickListener(this);
            viewHolder.banned.setOnClickListener(this);
            viewHolder.warning.setOnClickListener(this);
            viewHolder.nickname.setText(userBeans.get(0).getNickname());

            viewHolder.userHeadImage.setOnClickListener(this);

            new MyImageLoader().displayImage(context, "http://pic2.cxtuku.com/00/16/04/b163c9e46800.jpg", viewHolder.userHeadImage);
            viewHolder.createTime.setText(arrs[0] + " " + arrs[1]);
            viewHolder.title.setText(rmLists.get(position).getWorkDesc());
            viewHolder.repin1.setText(commentsBeans.get(0).getNickname() + ":" + commentsBeans.get(0).getContent());
            viewHolder.repin2.setText(commentsBeans.get(1).getNickname() + ":" + commentsBeans.get(1).getContent());
        }
    }

    @Override
    public int getItemCount() {
        return rmLists == null ? 0 : rmLists.size();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.timg:
                Toast.makeText(context, "点击了1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.warning:
                Toast.makeText(context, "点击了2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.banned:
                Toast.makeText(context, "点击了3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.userHeadImage:
                Intent intent = new Intent(context, UserDetailsActivity.class);
                intent.putExtra("uid", uid);
                context.startActivity(intent);
                break;
        }
    }

    class TJitemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.userHeadImage)
        ImageView userHeadImage;
        @BindView(R.id.nickname)
        TextView nickname;
        @BindView(R.id.createTime)
        TextView createTime;
        @BindView(R.id.timg)
        ImageView timg;
        @BindView(R.id.warning)
        ImageView warning;
        @BindView(R.id.banned)
        ImageView banned;
        @BindView(R.id.tv_timg)
        TextView tvTimg;
        @BindView(R.id.tv_warning)
        TextView tvWarning;
        @BindView(R.id.tv_banned)
        TextView tvBanned;
        @BindView(R.id.img_publish)
        ImageView imgPublish;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.repin1)
        TextView repin1;
        @BindView(R.id.repin2)
        TextView repin2;
        @BindView(R.id.inc_menu)
        RelativeLayout incMenu;
        @BindView(R.id.videoplayer)
        JZVideoPlayerStandard videoplayer;
        public List<ImageView> imageViews;
        public List<TextView> textViews;

        public TJitemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
