package com.example.administrator.sport.activity;


import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.sport.fragment.Fragment1;
import com.example.administrator.sport.fragment.Fragment2;
import com.example.administrator.sport.fragment.Fragment3;
import com.example.administrator.sport.fragment.Fragment4;
import com.example.administrator.sport.R;


public class MainActivity extends BaseActivity {
private android.support.v4.app.FragmentManager fragmentManager;
  private android.support.v4.app.FragmentTransaction fragmentTransaction;
    private FrameLayout layout1;
    private FrameLayout layout2;
    private FrameLayout layout3;
    private FrameLayout layout4;
    private ImageView[] image=new ImageView[8];
    private TextView[] text=new TextView[4];
    int count=0;
    private  Fragment[] fragments=new Fragment[4];
    @Override
    public void addLayout() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initView() {
        layout1= (FrameLayout) findViewById(R.id.layout1);
        layout2= (FrameLayout) findViewById(R.id.layout2);
        layout3= (FrameLayout) findViewById(R.id.layout3);
        layout4= (FrameLayout) findViewById(R.id.layout4);
        image[0]= (ImageView) findViewById(R.id.iv2);
        image[1]= (ImageView) findViewById(R.id.iv4);
        image[2]= (ImageView) findViewById(R.id.iv6);
        image[3]= (ImageView) findViewById(R.id.iv8);
        image[4]= (ImageView) findViewById(R.id.iv1);
        image[5]= (ImageView) findViewById(R.id.iv3);
        image[6]= (ImageView) findViewById(R.id.iv5);
        image[7]= (ImageView) findViewById(R.id.iv7);
        text[0]= (TextView) findViewById(R.id.tv1);
        text[1]= (TextView) findViewById(R.id.tv2);
        text[2]= (TextView) findViewById(R.id.tv3);
        text[3]= (TextView) findViewById(R.id.tv4);
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragments[0]= new Fragment1();
        fragmentTransaction.add(R.id.framLayout,fragments[0]);
        fragmentTransaction.commit();
        count=0;
        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               choiceFragment(0);
             show(0);

            }
        });
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choiceFragment(1);
                show(1);
            }
        });
        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choiceFragment(2);
                show(2);
            }
        });
        layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choiceFragment(3);
                show(3);
            }
        });

    }

    public  void choiceFragment(int index){
        if(count!=index){
            fragmentTransaction=fragmentManager.beginTransaction();

            if(fragments[index]==null){
                fragments[index]=newFragment(index);
                fragmentTransaction.add(R.id.framLayout,fragments[index]);

            }else{
                fragmentTransaction.show(fragments[index]);
            }
            fragmentTransaction.hide(fragments[count]);
            fragmentTransaction.commit();
            count=index;
        }
    }

    private Fragment newFragment(int index) {
        switch (index){
            case 0:
                return  new Fragment1();
            case 1:
                return  new Fragment2();
            case 2:
                return  new Fragment3();
            case 3:
                return  new Fragment4();

        }
        return null;
    }
    private  void  show(int index){
         for(int i=0;i<4;i++){
             image[i].setVisibility(View.INVISIBLE);
             text[i].setTextColor(0xff696969);
         }
        for(int j=4;j<8;j++){
            image[j].setVisibility(View.VISIBLE);

        }
        image[index+4].setVisibility(View.INVISIBLE);
        image[index].setVisibility(View.VISIBLE);
        text[index].setTextColor(0xff2B61C0);
    }

}
