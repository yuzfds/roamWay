package com.example.yuzf.roamway.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.yuzf.roamway.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView backToLoggin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }

    private void init() {
        backToLoggin = findViewById(R.id.backToLogin);
        backToLoggin.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.backToLogin:
                intent = new Intent(RegisterActivity.this,LoginActivity.class);
                finish();
                startActivity(intent);
                break;
        }
    }
}
