package com.boreas.quarterhour.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.model.AttentionBean;
import com.boreas.quarterhour.model.SelectBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by dream on 2018/2/3.
 */

public class MyRecyclerAdapter3 extends RecyclerView.Adapter<MyRecyclerAdapter3.MyViewHolder> {

    private List<SelectBean.DataBean> mDatas;
    private Context mContext;
    private LayoutInflater inflater;

    public MyRecyclerAdapter3(Context context, List<SelectBean.DataBean> datas){
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
    public void onBindViewHolder(MyRecyclerAdapter3.MyViewHolder holder, int position) {

        holder.tv1.setText( mDatas.get(position).getUsername());
        holder.tv2.setText( mDatas.get(position).getCreatetime());
        Glide.with(mContext).load(mDatas.get(position).getIcon()).placeholder(R.mipmap.ic_launcher).into(holder.img);
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"关注成功",Toast.LENGTH_SHORT).show();
            }
        });
    }

    //重写onCreateViewHolder方法，返回一个自定义的ViewHolder
    @Override
    public MyRecyclerAdapter3.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout. item_select,parent, false);
        MyRecyclerAdapter3.MyViewHolder holder= new MyRecyclerAdapter3.MyViewHolder(view);
        return holder;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv1,tv2;
        ImageView img;
        Button btn;

        public MyViewHolder(View view) {
            super(view);
            tv1=(TextView) view.findViewById(R.id.tv1);
            tv2 = view.findViewById(R.id.tv2);
            img = view.findViewById(R.id.img);
            btn = view.findViewById(R.id.btn);
        }

    }
}
