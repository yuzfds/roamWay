package com.example.yuzf.roamway.presenter;

import com.example.yuzf.roamway.model.IUserModel;
import com.example.yuzf.roamway.view.IUserView;

/**
 * Created by yuzf on 2018/6/19.
 * Class Note:
 */

public interface IUserPreseter {
    void login(IUserModel model, IUserView iUserView);
    void reg(IUserModel model, IUserView iUserView);
}
