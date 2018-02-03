package com.boreas.quarterhour.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.model.AttentionBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by dream on 2018/2/2.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    private List<AttentionBean.DataBean> mDatas;
    private Context mContext;
    private LayoutInflater inflater;

    public MyRecyclerAdapter(Context context, List<AttentionBean.DataBean> datas){
        this. mContext=context;
        this. mDatas=datas;
        inflater=LayoutInflater. from(mContext);
    }

    @Override
    public int getItemCount() {

        return mDatas.size();
    }

    //填充onCreateViewHolder方法返回的holder中的控件
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv.setText( mDatas.get(position).getNickname());
        holder.tv2.setText( mDatas.get(position).getUsername());
        holder.tv3.setText( mDatas.get(position).getCreatetime());
        Glide.with(mContext).load(mDatas.get(position).getIcon()).placeholder(R.mipmap.ic_launcher).into(holder.img);
    }

    //重写onCreateViewHolder方法，返回一个自定义的ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout. item_home,parent, false);
        MyViewHolder holder= new MyViewHolder(view);
        return holder;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv,tv2,tv3;
        ImageView img;

        public MyViewHolder(View view) {
            super(view);
            tv=(TextView) view.findViewById(R.id.tv);
            tv2 = view.findViewById(R.id.tv2);
            tv3 = view.findViewById(R.id.tv3);
            img = view.findViewById(R.id.img);
        }

    }
}