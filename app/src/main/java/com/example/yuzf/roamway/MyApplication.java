package com.example.yuzf.roamway;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by yuzf on 2018/6/19.
 * Class Note: 初始化Realm
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);
    }
}
