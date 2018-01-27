package com.boreas.quarterhour.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.model.VideoHotBean;
import com.boreas.quarterhour.view.activity.MainActivity;
import com.boreas.quarterhour.view.activity.VideoHotDetailsActivity;
import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Lonely on 2018/1/25.
 */

public class VideoHotAdapter extends XRecyclerView.Adapter<VideoHotAdapter.ViewHolder> {

    Context context;
    List<VideoHotBean.DataBean> list;

    public VideoHotAdapter(Context context, List<VideoHotBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public VideoHotAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_video_hot_item, null));
    }

    @Override
    public void onBindViewHolder(VideoHotAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getCover()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.a).into(holder.imageView);
//        holder.textView.setText(list.get(position).getCreateTime());
        System.out.println("list = " + list.get(position).getCover());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context , VideoHotDetailsActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends XRecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.video_hot_item_imageview);
        }
    }
}
