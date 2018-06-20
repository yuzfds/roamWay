package com.example.yuzf.roamway.presenter;

import com.example.yuzf.roamway.model.IUserModel;
import com.example.yuzf.roamway.model.LoginListener;
import com.example.yuzf.roamway.model.RegisterListener;
import com.example.yuzf.roamway.model.User;
import com.example.yuzf.roamway.view.IUserView;

/**
 * Created by yuzf on 2018/6/19.
 * Class Note:
 */

public class IUserPresenterImpl implements IUserPreseter{

    @Override
    public void login(IUserModel model, final IUserView iUserView) {
        model.login(new User(iUserView.getMail(), iUserView.getPassword()), new LoginListener() {
            @Override
            public void loginSuccess(User user) {
                iUserView.jumpActivity(user.getName());
            }

            @Override
            public void loginError(String error) {
                iUserView.showError(error);
            }
        });
    }

    @Override
    public void reg(IUserModel model, final IUserView iUserView) {
        model.register(new User(iUserView.getName(), iUserView.getMail(), iUserView.getPassword()), new RegisterListener() {
            @Override
            public void regSuccess() {
                iUserView.jumpActivity(iUserView.getName());
            }

            @Override
            public void regError(String msg) {
                iUserView.showError(msg);
            }
        });
    }
}
