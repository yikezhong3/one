package com.boreas.quarterhour.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.model.CrossTalkBean;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/1/20.
 */

public class CrossTalkAdapter extends RecyclerView.Adapter<CrossTalkAdapter.IHoldView> {
    Context context;
    List<CrossTalkBean.DataBean> dzBean;
    public CrossTalkAdapter(Context context, List<CrossTalkBean.DataBean> dzBean) {
        this.context=context;
        this.dzBean=dzBean;
    }
    @Override
    public IHoldView onCreateViewHolder(ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(context).inflate(R.layout.adapter_dz1,null);
        return new IHoldView(view);
    }

    @Override
    public void onBindViewHolder(IHoldView holder, int position) {
        holder.dzname.setText(dzBean.get(position).getContent());
        holder.dztime.setText(dzBean.get(position).getCreateTime());
       holder.dztext.setText(dzBean.get(position).getUser().getNickname());
        Glide.with(context).load(dzBean.get(position).getUser().getIcon());
       /* holder.dzicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });
       holder.dzjiadan.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(context, "加号", Toast.LENGTH_SHORT).show();
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

        }
    }
}
