package com.example.yuzf.roamway.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuzf.roamway.R;
import com.example.yuzf.roamway.model.UserModelImpl;
import com.example.yuzf.roamway.presenter.IUserPresenterImpl;
import com.example.yuzf.roamway.presenter.IUserPreseter;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, IUserView{

    private ImageView backToLoggin;
    private EditText username,usermail,password;
    private TextView reg_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }

    private void init() {
        backToLoggin = findViewById(R.id.backToLogin);
        password = findViewById(R.id.reg_password);
        username = findViewById(R.id.reg_username);
        usermail = findViewById(R.id.reg_mail);
        reg_btn = findViewById(R.id.main_btn_register);
        reg_btn.setOnClickListener(this);
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
            case R.id.main_btn_register:
                IUserPreseter preseter = new IUserPresenterImpl();
                preseter.reg(new UserModelImpl(),this);
                break;

        }
    }

    @Override
    public String getMail() {
        return usermail.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public String getName() {
        return username.getText().toString();
    }

    @Override
    public void jumpActivity(String name) {
        Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
        intent.putExtra("username",name);
        finish();
        startActivity(intent);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(RegisterActivity.this, error, Toast.LENGTH_SHORT).show();
    }
}
