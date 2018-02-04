package com.boreas.quarterhour.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.boreas.quarterhour.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ImageShowActivity extends AppCompatActivity {

    private ImageView img;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_show);
        img = findViewById(R.id.imageview);
        button = findViewById(R.id.btn);
        String url = getIntent().getStringExtra("url");
        Glide.with(this).load(url).into(img);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return super.onTouchEvent(event);
    }
}