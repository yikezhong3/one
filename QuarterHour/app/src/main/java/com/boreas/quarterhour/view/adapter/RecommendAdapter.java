package com.boreas.quarterhour.view.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.model.CarouselModel;
import com.boreas.quarterhour.model.RMBean;
import com.boreas.quarterhour.utils.MyImageLoader;
import com.boreas.quarterhour.utils.ShowAnimUtil;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
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
    private boolean isMenuOpen = false;

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

            viewHolder.imgPublish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!rmLists.get(position).isMenuOpen()) {
                        //showOpenAnim(viewHolder, 140);
                        new ShowAnimUtil().showOpenAnim(context,viewHolder,viewHolder.imageViews,viewHolder.textViews,viewHolder.imgPublish,140);
                        viewHolder.imgPublish.setImageResource(R.mipmap.ico_minus);
                        rmLists.get(position).setMenuOpen(true);
                    } else {
                        //showCloseAnim(viewHolder, 140);
                        new ShowAnimUtil().showCloseAnim(context,viewHolder,viewHolder.imageViews,viewHolder.textViews,viewHolder.imgPublish,140);
                        viewHolder.imgPublish.setImageResource(R.mipmap.ico_plus);
                        rmLists.get(position).setMenuOpen(false);
                    }
                }
            });
            viewHolder.timg.setOnClickListener(this);
            viewHolder.banned.setOnClickListener(this);
            viewHolder.warning.setOnClickListener(this);
            viewHolder.nickname.setText(userBeans.get(0).getNickname());
            String url = "http://ic.snssdk.com/neihan/video/playback/?video_id=3037a89e9e3f44338e2c55e0927e43f7&quality=480p&line=0&is_gif=0&device_platform=.mp4";

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
        switch (view.getId()){
            case R.id.timg:
                Toast.makeText(context,"点击了1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.warning:
                Toast.makeText(context,"点击了2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.banned:
                Toast.makeText(context,"点击了3",Toast.LENGTH_SHORT).show();
                break;
        }
    }

/*    //打开
    private void showOpenAnim(TJitemViewHolder viewHolder, int dp) {
        viewHolder.timg.setVisibility(View.VISIBLE);
        viewHolder.banned.setVisibility(View.VISIBLE);
        viewHolder.warning.setVisibility(View.VISIBLE);
        viewHolder.tvTimg.setVisibility(View.VISIBLE);
        viewHolder.tvBanned.setVisibility(View.VISIBLE);
        viewHolder.tvWarning.setVisibility(View.VISIBLE);
        //for循环来开始小图标的出现动画
        for (int i = 0; i < viewHolder.imageViews.size(); i++) {
            AnimatorSet set = new AnimatorSet();
            double a = -(25 * Math.PI / 180 * (i + 1));
            double x = a * dip2px(dp);
            Log.e("aaaaaaa", a + "");
            // double y = b * dip2px(dp);
            //ObjectAnimator.ofFloat(textViews.get(i), "trans lationY", (float) (y * 0.25), (float) y),
            set.playTogether(
                    ObjectAnimator.ofFloat(viewHolder.imageViews.get(i), "translationX", (float) (x * 0.25), (float) x),
                    ObjectAnimator.ofFloat(viewHolder.imageViews.get(i), "rotation", 360, 0).setDuration(1000),
                    ObjectAnimator.ofFloat(viewHolder.imageViews.get(i), "alpha", 0, 1).setDuration(1000),
                    ObjectAnimator.ofFloat(viewHolder.textViews.get(i), "translationX", (float) (x * 0.25), (float) x),
                    ObjectAnimator.ofFloat(viewHolder.textViews.get(i), "alpha", 0, 1).setDuration(1000)
            );
            //this is 弹弹弹
            //set.setInterpolator(new BounceInterpolator());
            set.setDuration(1000);
            set.start();
        }

        //转动加号大图标本身
        ObjectAnimator rotate = ObjectAnimator.ofFloat(viewHolder.imgPublish, "rotation", 360, 0).setDuration(1000);
        //this is 弹弹弹
        //rotate.setInterpolator(new BounceInterpolator());
        rotate.start();

    }

    //关闭
    private void showCloseAnim(final TJitemViewHolder viewHolder, int dp) {
        double a = 0;
        double x = 0;
        for (int i = 0; i < viewHolder.imageViews.size(); i++) {
            AnimatorSet set = new AnimatorSet();
            a = -(25 * Math.PI / 180 * (i + 1));
            //double b = -Math.sin(20 * Math.PI / 180 * (i * 2 + 1));
            x = a * dip2px(dp);
            //double y = b * dip2px(dp);
            //ObjectAnimator.ofFloat(textViews.get(i), "translationY", (float) y, (float) (y * 0.25)),
            set.playTogether(
                    ObjectAnimator.ofFloat(viewHolder.imageViews.get(i), "translationX", (float) x, (float) (x * 0.25)),
                    ObjectAnimator.ofFloat(viewHolder.imageViews.get(i), "rotation", 0, 360).setDuration(1000),
                    ObjectAnimator.ofFloat(viewHolder.imageViews.get(i), "alpha", 1, 0).setDuration(1000),
                    ObjectAnimator.ofFloat(viewHolder.textViews.get(i), "translationX", (float) x, (float) (x * 0.25)),
                    ObjectAnimator.ofFloat(viewHolder.textViews.get(i), "alpha", 1, 0).setDuration(1000)
            );
            //this is 弹弹弹
            //set.setInterpolator(new AccelerateInterpolator());
            set.setDuration(1000);
            set.start();

            set.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    viewHolder.timg.setVisibility(View.GONE);
                    viewHolder.banned.setVisibility(View.GONE);
                    viewHolder.warning.setVisibility(View.GONE);
                    viewHolder.tvTimg.setVisibility(View.GONE);
                    viewHolder.tvBanned.setVisibility(View.GONE);
                    viewHolder.tvWarning.setVisibility(View.GONE);
                    //菜单状态置关闭
                    isMenuOpen = false;
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }
        //转动加号大图标本身
        ObjectAnimator rotate = ObjectAnimator.ofFloat(viewHolder.imgPublish, "rotation", 0, 360).setDuration(1000);
        //this is 弹弹弹
        //rotate.setInterpolator(new BounceInterpolator());
        rotate.start();
    }

    //转换dp参数为px值
    private int dip2px(int value) {
        float density = context.getResources()
                .getDisplayMetrics().density;
        return (int) (density * value + 0.5f);
    }*/

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
        @BindView(R.id.simple_player_volume_controller)
        SeekBar simplePlayerVolumeController;

        public List<ImageView> imageViews;
        public List<TextView> textViews;


        public TJitemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
