package com.example.yuzf.roamway.model;

import io.realm.RealmObject;

/**
 * Created by yuzf on 2018/6/19.
 * Class Note: 用户，存于本地，懒得放到服务端
 */

public class User extends RealmObject{

    private String name;
    private String mail;
    private String password;

    public User() {
    }

    public User(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
    }

    public User(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
