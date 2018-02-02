package com.boreas.quarterhour.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 123 on 2018/1/27.
 */

public class ShowAnimUtil {
    //打开
    public void showOpenAnim(Context context, RecyclerView.ViewHolder viewHolder, List<ImageView> list1, List<TextView> list2, ImageView image, int dp) {

        //for循环来开始小图标的出现动画
        for (int i = 0; i < list1.size(); i++) {
            list1.get(i).setVisibility(View.VISIBLE);
            list2.get(i).setVisibility(View.VISIBLE);
            list1.get(i).bringToFront();
            list2.get(i).bringToFront();
            AnimatorSet set = new AnimatorSet();
            double a = -(25 * Math.PI / 180 * (i + 1));
            double x = a * dip2px(dp,context);
            Log.e("aaaaaaa", a + "");
            // double y = b * dip2px(dp);
            //ObjectAnimator.ofFloat(textViews.get(i), "trans lationY", (float) (y * 0.25), (float) y),
            set.playTogether(
                    ObjectAnimator.ofFloat(list1.get(i), "translationX", (float) (x * 0.25), (float) x),
                    ObjectAnimator.ofFloat(list1.get(i), "rotation", 360, 0).setDuration(1000),
                    ObjectAnimator.ofFloat(list1.get(i), "alpha", 0, 1).setDuration(1000),
                    ObjectAnimator.ofFloat(list2.get(i), "translationX", (float) (x * 0.25), (float) x),
                    ObjectAnimator.ofFloat(list2.get(i), "alpha", 0, 1).setDuration(1000)
            );
            //this is 弹弹弹
            //set.setInterpolator(new BounceInterpolator());
            set.setDuration(1000);
            set.start();
        }

        //转动加号大图标本身
        ObjectAnimator rotate = ObjectAnimator.ofFloat(image, "rotation", 360, 0).setDuration(1000);
        //this is 弹弹弹
        //rotate.setInterpolator(new BounceInterpolator());
        rotate.start();

    }

    //关闭
    public void showCloseAnim(Context context, final RecyclerView.ViewHolder viewHolder, final List<ImageView> list1, final List<TextView> list2, ImageView image, int dp) {
        double a = 0;
        double x = 0;
        for (int i = 0; i < list1.size(); i++) {
            AnimatorSet set = new AnimatorSet();
            a = -(25 * Math.PI / 180 * (i + 1));
            //double b = -Math.sin(20 * Math.PI / 180 * (i * 2 + 1));
            x = a * dip2px(dp, context);
            //double y = b * dip2px(dp);
            //ObjectAnimator.ofFloat(textViews.get(i), "translationY", (float) y, (float) (y * 0.25)),
            set.playTogether(
                    ObjectAnimator.ofFloat(list1.get(i), "translationX", (float) x, (float) (x * 0.25)),
                    ObjectAnimator.ofFloat(list1.get(i), "rotation", 0, 360).setDuration(1000),
                    ObjectAnimator.ofFloat(list1.get(i), "alpha", 1, 0).setDuration(1000),
                    ObjectAnimator.ofFloat(list2.get(i), "translationX", (float) x, (float) (x * 0.25)),
                    ObjectAnimator.ofFloat(list2.get(i), "alpha", 1, 0).setDuration(1000)
            );
            //this is 弹弹弹
            //set.setInterpolator(new AccelerateInterpolator());
            set.setDuration(1000);
            set.start();

            set.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    for ( int i = 0; i < list1.size(); i++){
                        list1.get(i).setVisibility(View.GONE);
                        list2.get(i).setVisibility(View.GONE);
                    }
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }
        //转动加号大图标本身
        ObjectAnimator rotate = ObjectAnimator.ofFloat(image, "rotation", 0, 360).setDuration(1000);
        //this is 弹弹弹
        //rotate.setInterpolator(new BounceInterpolator());
        rotate.start();
    }

    //转换dp参数为px值
    private int dip2px(int value, Context context) {
        float density = context.getResources()
                .getDisplayMetrics().density;
        return (int) (density * value + 0.5f);
    }
}
