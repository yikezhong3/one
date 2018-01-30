package com.boreas.quarterhour.view.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.model.UserDetailBean;
import com.boreas.quarterhour.utils.CornersTransform;
import com.boreas.quarterhour.utils.MyImageLoader;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
                    notifyDataSetChanged();
                } else {
                    holderOne.btFollow.setBackgroundResource(R.drawable.bg_tv_guanzhu);
                    holderOne.btFollow.setText("+关注");
                    playNum--;
                    holderOne.btFollow.setTextColor(context.getResources().getColor(R.color.textColorUserDatils));
                    holderOne.btFollow.setTag(1);
                    notifyDataSetChanged();
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
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_tj,null,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder){
            ViewHolder viewHolder = (ViewHolder) holder;

        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
