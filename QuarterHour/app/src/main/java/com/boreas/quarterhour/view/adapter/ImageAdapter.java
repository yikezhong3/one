package com.boreas.quarterhour.view.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.boreas.quarterhour.R;
import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by Dell on 2018/1/29.
 */

public class ImageAdapter extends RecyclerArrayAdapter<String> {
    public ImageAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return  new ImageViewHolder(parent);
    }




    class ImageViewHolder extends BaseViewHolder<String> {
        ImageView imgPicture;

        public ImageViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_found);
            imgPicture = $(R.id.image);
            imgPicture.setScaleType(ImageView.ScaleType.FIT_XY);
        }

        @Override
        public void setData(String data) {
            ViewGroup.LayoutParams params = imgPicture.getLayoutParams();

            DisplayMetrics dm = getContext().getResources().getDisplayMetrics();
            int width = dm.widthPixels / 2;//宽度为屏幕宽度一半
//            int height = data.getHeight() * width / data.getWidth();//计算View的高度

            params.height = (int) (width / 0.8);
            imgPicture.setLayoutParams(params);
            imgPicture.setImageResource(R.mipmap.ic_launcher);
            Glide.with(getContext())
                    .load(data)
                    .into(imgPicture);
        }
    }

}
