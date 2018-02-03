package com.boreas.quarterhour.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.model.CollectBean;
import com.bumptech.glide.Glide;

/**
 * Created by dream on 2018/2/2.
 */

public class MyRecyclerAdapter2 extends RecyclerView.Adapter<MyRecyclerAdapter2.MyViewHolder> {

    private CollectBean collectBean;
    private Context mContext;
    private LayoutInflater inflater;

    public MyRecyclerAdapter2(Context context, CollectBean collectBean){
        this. mContext=context;
        this. collectBean=collectBean;
        inflater=LayoutInflater. from(mContext);
    }

    @Override
    public int getItemCount() {

        return collectBean.getData().size();
    }

    //填充onCreateViewHolder方法返回的holder中的控件
    @Override
    public void onBindViewHolder(MyRecyclerAdapter2.MyViewHolder holder, int position) {

        holder.tv1.setText( collectBean.getData().get(position).getWorkDesc());
        holder.tv2.setText( collectBean.getData().get(position).getCreateTime());
        Glide.with(mContext).load(collectBean.getData().get(position).getCover()).placeholder(R.mipmap.ic_launcher).into(holder.img1);
        Glide.with(mContext).load(collectBean.getData().get(position).getCover()).placeholder(R.mipmap.ic_launcher).into(holder.img2);
    }

    //重写onCreateViewHolder方法，返回一个自定义的ViewHolder
    @Override
    public MyRecyclerAdapter2.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout. item_collect,parent, false);
        MyRecyclerAdapter2.MyViewHolder holder= new MyRecyclerAdapter2.MyViewHolder(view);
        return holder;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv1,tv2;
        ImageView img1,img2;

        public MyViewHolder(View view) {
            super(view);

            tv1=(TextView) view.findViewById(R.id.tv1);
            tv2 = view.findViewById(R.id.tv2);
            img1 = view.findViewById(R.id.img1);
            img2 = view.findViewById(R.id.img2);
        }

    }
}
