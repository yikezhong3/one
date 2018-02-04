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
import com.boreas.quarterhour.model.BendiBean;
import com.boreas.quarterhour.utils.MyOnItemClickListener;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by dream on 2018/2/3.
 */

public class MyRecyclerAdapter4 extends RecyclerView.Adapter<MyRecyclerAdapter4.MyViewHolder> {
    private MyOnItemClickListener itemClickListener;
    /**列表点击事件
     *
             * @param itemClickListener
     */
    public void setOnItemClickListener(MyOnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    private List<BendiBean.NewslistBean> mDatas;
    private Context mContext;
    private LayoutInflater inflater;

    public MyRecyclerAdapter4(Context context, List<BendiBean.NewslistBean> datas){
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
    public void onBindViewHolder(final MyRecyclerAdapter4.MyViewHolder holder, int position) {

        Glide.with(mContext).load(mDatas.get(position).getPicUrl()).placeholder(R.mipmap.ic_launcher).into(holder.img);
   /*自定义item的点击事件不为null，设置监听事件*/
        if (itemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.OnItemClickListener(holder.itemView, holder.getLayoutPosition());
                }
            });
        }
    }

    //重写onCreateViewHolder方法，返回一个自定义的ViewHolder
    @Override
    public MyRecyclerAdapter4.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout. item_f1,null, false);
        MyRecyclerAdapter4.MyViewHolder holder= new MyRecyclerAdapter4.MyViewHolder(view);
        return holder;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img;

        public MyViewHolder(View view) {
            super(view);
            img = view.findViewById(R.id.img);
        }

    }
}
