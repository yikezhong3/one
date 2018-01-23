package com.boreas.quarterhour.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.boreas.quarterhour.MainActivity;
import com.boreas.quarterhour.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.callback)
    ImageView callback;
    @BindView(R.id.existing_account)
    TextView existingAccount;
    @BindView(R.id.register)
    Button register;
    @BindView(R.id.tourist)
    TextView tourist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.callback, R.id.existing_account, R.id.register, R.id.tourist})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.callback:
                finish();
                break;
            case R.id.existing_account:
                finish();
                break;
            case R.id.register:
                Toast.makeText(this,"注册",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tourist:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}
