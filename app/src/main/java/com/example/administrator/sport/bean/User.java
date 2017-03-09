package com.example.administrator.sport.bean;

/**
 * Created by Administrator on 2017/3/7.
 */

public class User {
    private String name;
    private int image;

    public User() {
    }

    public User(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
