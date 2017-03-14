package com.example.administrator.sport.activity;

import android.os.Handler;

import com.example.administrator.sport.R;

/**
 * Created by Administrator on 2017/3/13.
 */

public class LogoActivity  extends BaseActivity{
    @Override
    public void addLayout() {
          setContentView(R.layout.logoactivity);
    }

    @Override
    public void initView() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                gotoActivity(MainActivity.class);
                finish();
            }
        }, 100*50);
    }
}
