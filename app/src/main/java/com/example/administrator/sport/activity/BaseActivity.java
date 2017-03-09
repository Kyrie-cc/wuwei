package com.example.administrator.sport.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.administrator.sport.R;

/**
 * Created by Administrator on 2017/2/27.
 */

public  abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addLayout();
        initView();
    }

//    加载布局
    public abstract  void addLayout();
//    FindViewById找控件
    public abstract  void initView();
//    跳转页面
    public void gotoActivity(Class<?> activity){
        Intent intent=new Intent(this,activity);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.left_in,R.anim.left_out);
    }
    public void showToast(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
    public void showDialog(){}

}
