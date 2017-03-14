package com.example.administrator.sport.bean;

/**
 * Created by Administrator on 2017/3/13.
 */

public class People {
    private  String img1;
    private  String img2;
    private  String img3;
    private   String title;
    private  String author;
    private  String date;
    private  String url;
    private  boolean isCheck;
    public People(String img1, String img2, String img3, String title, String author, String date, String url) {
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.title = title;
        this.author = author;
        this.date = date;
        this.url = url;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}
