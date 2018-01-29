package com.boreas.quarterhour.view.adapter;

import android.content.Context;
import android.content.Intent;
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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/1/29.
 */

public class CrossTalkAdapterr extends RecyclerView.Adapter<CrossTalkAdapterr.IViewHolder> {
    Context context;
    List<CrossTalkBean.DataBean> list;


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
    public void onBindViewHolder(IViewHolder holder, int position) {
              holder.adapterDztext.setText(list.get(position).getContent());
              holder.adapterDztime.setText(list.get(position).getCreateTime());
              holder.adapterDzname.setText(list.get(position).getUser().getNickname());
              holder.adapterDzname.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Intent intent = new Intent(context, PersonaldetailsActivity.class);
                      context.startActivity(intent);
                  }
              });
        holder.adapterDztime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PersonaldetailsActivity.class);
                context.startActivity(intent);
            }
        });
        holder.adapterDzicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PersonaldetailsActivity.class);
                context.startActivity(intent);
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
        return list == null ? 0 : list.size();
    }

    public class IViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.adapter_dzicon)
        ImageView adapterDzicon;
        @BindView(R.id.adapter_dzname)
        TextView adapterDzname;
        @BindView(R.id.adapter_dztime)
        TextView adapterDztime;
       @BindView(R.id.adapter_dzjiadan)
       ImageView dzjiadan;
        @BindView(R.id.adapter_dztext)
        TextView adapterDztext;
        public IViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
