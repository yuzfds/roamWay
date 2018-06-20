package com.example.yuzf.roamway.model;

/**
 * Created by yuzf on 2018/6/19.
 * Class Note:
 */

public interface IUserModel {

    void login(User user, LoginListener loginListener);

    void register(User user, RegisterListener registerListener);
}
