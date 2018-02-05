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
import com.boreas.quarterhour.model.SelectBean;
import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Random;

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

        String[] Usicon = {
                "http://p1.qq181.com/cms/120503/2012050322011423334.jpg",
                "http://p1.so.qhimgs1.com/t014803de8c7e2a2b7d.jpg",
                "http://www.16sucai.com/uploadfile/2013/0630/20130630095526852.jpg",
                "http://v1.qzone.cc/avatar/201406/12/14/00/539941ff03ebf693.png%21200x200.jpg",
                "http://www.qqw21.com/article/UploadPic/2012-10/2012102592515140.jpg",
                "http://pic.ik123.com/uploads/allimg/131021/16-131021141R6.jpg",
                "http://img2.touxiang.cn/file/20170106/c8426f3a7e8e38e0d5869042acae0283.jpg",
        };
        Random ran = new Random();
        int i = ran.nextInt(Usicon.length);
        String userIcon = Usicon[i];
        Glide.with(mContext).load(userIcon).into(holder.img);
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

        View view = inflater.inflate(R.layout.item_select,parent, false);
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
