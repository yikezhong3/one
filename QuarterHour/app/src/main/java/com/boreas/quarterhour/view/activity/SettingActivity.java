package com.boreas.quarterhour.view.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.boreas.quarterhour.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingActivity extends AppCompatActivity {
    Button log_out;
    @BindView(R.id.log_out)
    Button logOut;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);

        TextView textView = (TextView) findViewById(R.id.title).findViewById(R.id.callback);
        TextView title = (TextView) findViewById(R.id.title).findViewById(R.id.title1);
         textView.setText("<返回");
        title.setText("设置");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        log_out = findViewById(R.id.log_out);
        sp = getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.edit().clear().commit();
                Toast.makeText(SettingActivity.this, "退出登录", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }


//    @OnClick({R.id.callback})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.callback:
//                finish();
//                break;
//
//        }
//    }
}
