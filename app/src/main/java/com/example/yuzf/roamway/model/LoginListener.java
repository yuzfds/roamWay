package com.example.yuzf.roamway.model;

/**
 * Created by yuzf on 2018/6/19.
 * Class Note:登录监听
 */

public interface LoginListener {
    void loginSuccess(User user);

    void loginError(String error);
}
