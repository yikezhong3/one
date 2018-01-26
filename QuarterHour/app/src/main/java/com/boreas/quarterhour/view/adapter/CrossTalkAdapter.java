package com.boreas.quarterhour.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.model.CrossTalkBean;
import com.boreas.quarterhour.view.activity.PersonaldetailsActivity;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/1/26.
 */

public class CrossTalkAdapter extends RecyclerView.Adapter<CrossTalkAdapter.IHoldView>{
    Context context;
    List<CrossTalkBean.DataBean> dzBean;
    public CrossTalkAdapter(Context context, List<CrossTalkBean.DataBean> dzBean) {
        this.context=context;
        this.dzBean=dzBean;
    }
    @Override
    public IHoldView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LinearLayout.inflate(context, R.layout.adapter_dz1, null);
        return new IHoldView(view);
    }

    @Override
    public void onBindViewHolder(IHoldView holder, int position) {
        holder.dzname.setText(dzBean.get(position).getContent());
        holder.dztime.setText(dzBean.get(position).getCreateTime());
        holder.dztext.setText(dzBean.get(position).getUser().getNickname());
        Glide.with(context).load(dzBean.get(position).getUser().getIcon());
        holder.dztime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PersonaldetailsActivity.class);
                context.startActivity(intent);
            }
        });
        holder.dzname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PersonaldetailsActivity.class);
                context.startActivity(intent);
            }
        });
        holder.dzicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PersonaldetailsActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dzBean==null?0:dzBean.size();
    }

    public class IHoldView extends RecyclerView.ViewHolder {
        @BindView(R.id.adapter_dzicon)
        ImageView dzicon;
        @BindView(R.id.adapter_dzjiadan)
        ImageView dzjiadan;
        @BindView(R.id.adapter_dzname)
        TextView dzname;
        @BindView(R.id.adapter_dztext)
        TextView dztext;
        @BindView(R.id.adapter_dztime)
        TextView dztime;
        public IHoldView(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        dzjiadan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "加号", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
