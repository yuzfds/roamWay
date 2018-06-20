package com.example.yuzf.roamway.view;

/**
 * Created by yuzf on 2018/6/19.
 * Class Note:
 */

public interface IUserView {

    String getMail();
    String getPassword();
    String getName();
    void  jumpActivity(String name);
    void showError(String error);
}
