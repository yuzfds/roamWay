package com.example.yuzf.roamway.model;

import android.util.Log;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by yuzf on 2018/6/19.
 * Class Note:
 */

public class UserModelImpl implements IUserModel{
    private Realm realm;
    @Override
    public void login(User user, LoginListener loginListener) {
        String mail = user.getMail();
        String password = user.getPassword();
        realm = Realm.getDefaultInstance();
        RealmResults<User> users1= realm.where(User.class).findAll();
//        List<User> users = users1;
//        for (User u :users)
//            Log.i("alluser",u.toString());


        if(mail.equals("")||password.equals(""))
        {
            loginListener.loginError("请输入账号密码");
            return;
        }
        User user1 = realm.where(User.class).equalTo("mail",mail).findFirst();
        Log.i("user",user.toString());
        if(user1!=null) {
         //   Log.i("user1",user1.toString());
            if(user1.getPassword().equals(password)){
                loginListener.loginSuccess(user1);
            }else {
                loginListener.loginError("Incorretc password");
            }
        }else {
            loginListener.loginError("Incorretc username");
        }

    }

    @Override
    public void register(User user, RegisterListener registerListener) {

        realm = Realm.getDefaultInstance();
        User user1 = realm.where(User.class).equalTo("name",user.getName()).findFirst();
        if(user1==null){
            realm.beginTransaction();
            realm.copyToRealm(user);
            realm.commitTransaction();
            registerListener.regSuccess();
          //  User user2 = realm.where(User.class).equalTo("name",user.getName()).findFirst();
        }else {
            registerListener.regError("用户已存在");
          //  User user2 = realm.where(User.class).equalTo("name",user.getName()).findFirst();
        }


    }
}
