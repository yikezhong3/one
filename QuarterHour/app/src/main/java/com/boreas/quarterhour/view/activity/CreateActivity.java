package com.boreas.quarterhour.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.base.BaseActivity;
import com.boreas.quarterhour.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateActivity extends BaseActivity {


    @BindView(R.id.shiping)
    ImageView shiping;
    @BindView(R.id.duanzi)
    ImageView duanzi;
    @BindView(R.id.radio_text)
    TextView radio;
    @BindView(R.id.head_back)
    ImageView back;

    @Override
    protected void initDagger() {

    }

    @Override
    protected void initView() {
        radio.setText("创作");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        duanzi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateActivity.this,PropertyActivity.class));
            }
        });

        shiping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateActivity.this,FilmActivity.class));
            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.activity_create;
    }

    @Override
    public BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
