package com.boreas.quarterhour.view.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.model.UserDetailBean;
import com.boreas.quarterhour.utils.CornersTransform;
import com.boreas.quarterhour.utils.MyImageLoader;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by 123 on 2018/1/30.
 */

public class UserDetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private Context context;
    private List<UserDetailBean.DataBean> list;
    private int ONE = 0;
    private int TWO = 1;
    private ViewHolderOne holderOne;
    private int playNum;
    private int zanNum = 0;
    private ViewHolderTwo holderTwo;

    public UserDetailsAdapter(Context context) {
        this.context = context;
    }

    public void addData(UserDetailBean bean) {
        if (list == null) {
            list = new ArrayList<>();
        }
        for (UserDetailBean.DataBean b : bean.getData()) {
            list.add(b);
        }
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ONE) {
            return new ViewHolderOne(LayoutInflater.from(context).inflate(R.layout.item_user_detailes_tile, null));
        } else {
            return new ViewHolderTwo(LayoutInflater.from(context).inflate(R.layout.fragment_tj_item, null));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String userDetailGroundUrl = "http://img06.tooopen.com/images/20170916/tooopen_sy_224744914937.jpg";
        String userDetailImageUsl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517305649973&di=48f9cd2fe376b104e691f278e9fe5a33&imgtype=0&src=http%3A%2F%2Fimg1.50tu.com%2Fmeinv%2Fxinggan%2F2013-11-16%2Fe65e7cd83f37eed87067299266152807.jpg";
        if (list != null) {
            if (holder instanceof ViewHolderOne) {
                holderOne = (ViewHolderOne) holder;

                playNum = list.get(position).getPlayNum();
                Log.d("wid----",playNum+"---"+list.size()+"--wid--"+list.toString());
                new MyImageLoader().displayImage(context, userDetailGroundUrl, holderOne.userDetailGround);
                holderOne.userDetailGround.setScaleType(ImageView.ScaleType.FIT_XY);
                Glide.with(context).load(userDetailImageUsl).error(R.mipmap.slid_touxiang).transform(new CornersTransform(context, 10)).into(holderOne.userDetailImage);
                holderOne.userDetailImage.setScaleType(ImageView.ScaleType.FIT_XY);
                holderOne.worksNum.setText("作品(" + list.size() + ")");
                holderOne.followNum.setText(playNum + "关注");
                holderOne.zanNum.setText(zanNum + "");
                holderOne.btFollow.setOnClickListener(this);
                holderOne.fabulousNum.setOnClickListener(this);
            }else {
                holderTwo = (ViewHolderTwo) holder;
                LinearLayoutManager layoutManager = new LinearLayoutManager(context) {
                    @Override
                    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    }
                };
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                holderTwo.recycleTjItem.setLayoutManager(layoutManager);
                holderTwo.recycleTjItem.setAdapter(new UserDatilsTwoAdapter(context, list));
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_follow:
                int num = (Integer) holderOne.btFollow.getTag();
                if (num == 1) {
                    holderOne.btFollow.setBackgroundResource(R.drawable.bg_tv_yiguanzhu);
                    holderOne.btFollow.setText("已关注");
                    holderOne.btFollow.setTextColor(Color.WHITE);
                    playNum++;
                    holderOne.btFollow.setTag(2);

                } else {
                    holderOne.btFollow.setBackgroundResource(R.drawable.bg_tv_guanzhu);
                    holderOne.btFollow.setText("+关注");
                    playNum--;
                    holderOne.btFollow.setTextColor(context.getResources().getColor(R.color.textColorUserDatils));
                    holderOne.btFollow.setTag(1);

                }

                break;
            case R.id.fabulousNum:
                switch (zanNum) {
                    case 0:
                        zanNum++;
                        holderOne.fabulousNum.setBackgroundColor(context.getResources().getColor(R.color.fabulousOne));
                        holderOne.zanNum.setText(zanNum + "");
                        holderOne.zanImage.setImageResource(R.mipmap.dianzan);
                        break;
                    case 1:
                        zanNum++;
                        holderOne.fabulousNum.setBackgroundColor(context.getResources().getColor(R.color.fabulousTwo));
                        holderOne.zanNum.setText(zanNum + "");
                        holderOne.zanImage.setImageResource(R.mipmap.dianzan);
                        break;
                    case 2:
                        zanNum++;
                        holderOne.fabulousNum.setBackgroundColor(context.getResources().getColor(R.color.fabulousThree));
                        holderOne.zanNum.setText(zanNum + "");
                        holderOne.zanImage.setImageResource(R.mipmap.dianzan);
                        break;
                }
                break;

        }
    }

    class ViewHolderOne extends RecyclerView.ViewHolder {
        @BindView(R.id.userDetailGround)
        ImageView userDetailGround;
        @BindView(R.id.userDetailTitle)
        TextView userDetailTitle;
        @BindView(R.id.userDetailShare)
        ImageView userDetailShare;
        @BindView(R.id.userDetailFollow)
        ImageView userDetailFollow;
        @BindView(R.id.userDetailImage)
        ImageView userDetailImage;
        @BindView(R.id.fansNum)
        TextView fansNum;
        @BindView(R.id.followNum)
        TextView followNum;
        @BindView(R.id.bt_follow)
        TextView btFollow;
        @BindView(R.id.zanImage)
        ImageView zanImage;
        @BindView(R.id.zanNum)
        TextView zanNum;
        @BindView(R.id.fabulousNum)
        LinearLayout fabulousNum;
        @BindView(R.id.worksNum)
        TextView worksNum;

        public ViewHolderOne(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            btFollow.setTag(1);
        }
    }

    class ViewHolderTwo extends RecyclerView.ViewHolder {
        @BindView(R.id.recycle_tj_item)
        RecyclerView recycleTjItem;
        public ViewHolderTwo(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

class UserDatilsTwoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<UserDetailBean.DataBean> list;
    public UserDatilsTwoAdapter(Context context, List<UserDetailBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TJitemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_tj,null,false));
    }
    String[] Uri= {
            "http://p5.so.qhimgs1.com/bdr/200_200_/t014176f7a05b8f479b.jpg",
            "http://p0.so.qhimgs1.com/bdr/200_200_/t01af74f62990cb9c40.jpg",
            "http://img.pconline.com.cn/images/upload/upc/tx/itbbs/1308/25/c1/24851176_1377368343784_mthumb.jpg",
            "http://img.7139.com/file/201206/10/be31dbcba825d7d157919a96027d9d60.jpg",
            "http://www.nanrenwo.net/uploads/tagimg/3/141440266112318.jpg",
            "http://p5.so.qhimgs1.com/bdr/200_200_/t017f6f30f1a76d312b.jpg",
            "http://p2.so.qhimgs1.com/bdr/200_200_/t0185334976ac01c742.jpg",
            "http://i2.hexunimg.cn/2011-11-30/135834127.jpg",
            "http://photo.l99.com/bigger/31/1427449833570_9vpbg2.jpg"};
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

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
//            String url = "http://p5.so.qhimgs1.com/bdr/200_200_/t014176f7a05b8f479b.jpg";
                Random rand = new Random();
                int num = rand.nextInt(Uri.length);
                String s = Uri[num];
                viewHolder.videoplayer.setUp(url2, JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "搞笑娱乐");
                new MyImageLoader().displayImage(context,s, viewHolder.videoplayer.thumbImageView);
                viewHolder.videoplayer.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);

                viewHolder.incMenu.bringToFront();


            }


    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
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
