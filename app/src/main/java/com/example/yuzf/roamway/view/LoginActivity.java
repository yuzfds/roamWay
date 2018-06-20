package com.example.yuzf.roamway.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuzf.roamway.R;
import com.example.yuzf.roamway.model.LoginListener;
import com.example.yuzf.roamway.model.UserModelImpl;
import com.example.yuzf.roamway.presenter.IUserPresenterImpl;
import com.example.yuzf.roamway.presenter.IUserPreseter;
import com.example.yuzf.roamway.tools.JellyInterpolator;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener ,IUserView{
    private TextView mBtnLogin;
    private View progress;
    private View mInputLayout;
    private float mWidth, mHeight;
    private ImageView backtomain;
    private TextView register;
    private LinearLayout mName, mPsw;
    private EditText username ,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        mBtnLogin = (TextView) findViewById(R.id.main_btn_login);
        progress = findViewById(R.id.layout_progress);
        mInputLayout = findViewById(R.id.input_layout);
        mName = (LinearLayout) findViewById(R.id.input_layout_name);
        mPsw = (LinearLayout) findViewById(R.id.input_layout_psw);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        backtomain = findViewById(R.id.backToMain);
        register = findViewById(R.id.register);
        backtomain.setOnClickListener(this);
        register.setOnClickListener(this);
        mBtnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.main_btn_login:
                // 计算出控件的高与宽
                mWidth = mBtnLogin.getMeasuredWidth();
                mHeight = mBtnLogin.getMeasuredHeight();
                // 隐藏输入框
                mName.setVisibility(View.INVISIBLE);
                mPsw.setVisibility(View.INVISIBLE);
                inputAnimator(mInputLayout, mWidth, mHeight);
                IUserPreseter preseter = new IUserPresenterImpl();
                preseter.login(new UserModelImpl(),this);
                break;
            case R.id.backToMain:
                intent =new Intent(LoginActivity.this,MainActivity.class);
                finish();
                startActivity(intent);
                break;
            case R.id.register:
                intent =new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
        }

    }

    private void inputAnimator(final View view, float w, float h) {
        AnimatorSet set = new AnimatorSet();

        ValueAnimator animator = ValueAnimator.ofFloat(0, w);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (Float) animation.getAnimatedValue();
                ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view
                        .getLayoutParams();
                params.leftMargin = (int) value;
                params.rightMargin = (int) value;
                view.setLayoutParams(params);
            }
        });

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mInputLayout,
                "scaleX", 1f, 0.5f);
        set.setDuration(1000);
        set.setInterpolator(new AccelerateDecelerateInterpolator());
        set.playTogether(animator, animator2);
        set.start();
        set.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                /**
                 * 动画结束后，先显示加载的动画，然后再隐藏输入框
                 */
                progress.setVisibility(View.VISIBLE);
                progressAnimator(progress);
                mInputLayout.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }
        });
    }

    private void progressAnimator(final View view) {
        PropertyValuesHolder animator = PropertyValuesHolder.ofFloat("scaleX",
                0.5f, 1f);
        PropertyValuesHolder animator2 = PropertyValuesHolder.ofFloat("scaleY",
                0.5f, 1f);
        ObjectAnimator animator3 = ObjectAnimator.ofPropertyValuesHolder(view,
                animator, animator2);
        animator3.setDuration(1000);
        animator3.setInterpolator(new JellyInterpolator());
        animator3.start();

    }

    @Override
    public String getMail() {
        return username.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void jumpActivity(String name) {
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        intent.putExtra("username",name);
        finish();
        startActivity(intent);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(LoginActivity.this, error, Toast.LENGTH_SHORT).show();
    }

}
