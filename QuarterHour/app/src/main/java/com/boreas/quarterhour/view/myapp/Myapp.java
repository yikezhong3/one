package com.boreas.quarterhour.view.myapp;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by Dell on 2018/1/19.
 */

public class Myapp extends Application {

    public static Myapp mInstance;
    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance= this;
        UMShareAPI.get(this);
    }
    public static Myapp getmInstance(){
        return mInstance;
    }
    {

        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }
}
