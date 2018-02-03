package com.boreas.quarterhour.view.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.boreas.quarterhour.R;

public class SettingActivity extends AppCompatActivity {
     Button log_out;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        log_out = findViewById(R.id.log_out);
        sp = getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.edit().clear().commit();
                Toast.makeText(SettingActivity.this,"退出登录",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
