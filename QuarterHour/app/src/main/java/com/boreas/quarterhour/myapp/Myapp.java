package com.boreas.quarterhour.myapp;

import android.app.Application;

/**
 * Created by Dell on 2018/1/19.
 */

public class Myapp extends Application {

    public static Myapp mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance= this;
    }
    public static Myapp getmInstance(){
        return mInstance;
    }
}
