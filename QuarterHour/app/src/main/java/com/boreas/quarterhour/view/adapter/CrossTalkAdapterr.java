package com.boreas.quarterhour.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.model.CrossTalkBean;
import com.boreas.quarterhour.utils.ShowAnimUtil;
import com.boreas.quarterhour.view.activity.UserDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/1/29.
 */

public class CrossTalkAdapterr extends RecyclerView.Adapter<CrossTalkAdapterr.IViewHolder> {
    Context context;
    List<CrossTalkBean.DataBean> list;
    private String uid = "";

    public CrossTalkAdapterr(Context context, List<CrossTalkBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LinearLayout.inflate(context, R.layout.adapter_crosstalk, null);
        return new IViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final IViewHolder holder, final int position) {
        holder.imageViews = new ArrayList<>();
        holder.textViews = new ArrayList<>();
        holder.imageViews.add(holder.warning);
        holder.imageViews.add(holder.timg);
        holder.imageViews.add(holder.banned);
        holder.textViews.add(holder.tvBanned);
        holder.textViews.add(holder.tvWarning);
        holder.textViews.add(holder.tvTimg);
        holder.imgPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!list.get(position).isMenuOpen()) {
                    //showOpenAnim(viewHolder, 140);
                    new ShowAnimUtil().showOpenAnim(context, holder, holder.imageViews, holder.textViews, holder.imgPublish, 140);
                    holder.imgPublish.setImageResource(R.mipmap.ico_minus);
                    list.get(position).setMenuOpen(true);
                } else {
                    //showCloseAnim(viewHolder, 140);
                    new ShowAnimUtil().showCloseAnim(context, holder, holder.imageViews, holder.textViews, holder.imgPublish, 140);
                    holder.imgPublish.setImageResource(R.mipmap.ico_plus);
                    list.get(position).setMenuOpen(false);
                }
            }
        });
        uid = list.get(position).getUid() + "";
        holder.adapterDztext.setText(list.get(position).getContent());
        holder.adapterDztime.setText(list.get(position).getCreateTime());
        holder.adapterDzname.setText(list.get(position).getUser().getNickname());
        holder.adapterDzname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UserDetailsActivity.class);
                intent.putExtra("uid", uid);
                context.startActivity(intent);
            }
        });
        holder.adapterDztime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UserDetailsActivity.class);
                intent.putExtra("uid", uid);
                context.startActivity(intent);
            }
        });
        holder.adapterDzicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UserDetailsActivity.class);

                intent.putExtra("uid", uid);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class IViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.adapter_dzicon)
        ImageView adapterDzicon;
        @BindView(R.id.adapter_dzname)
        TextView adapterDzname;
        @BindView(R.id.adapter_dztime)
        TextView adapterDztime;
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
        @BindView(R.id.inc_menu)
        RelativeLayout incMenu;
        @BindView(R.id.adapter_dztext)
        TextView adapterDztext;
        public List<ImageView> imageViews;
        public List<TextView> textViews;
        public IViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
