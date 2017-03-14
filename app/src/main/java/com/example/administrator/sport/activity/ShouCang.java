package com.example.administrator.sport.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.sport.Adapter.RecylerViewAdapter;
import com.example.administrator.sport.Adapter.RecylerViewAdapter_ShouCang;
import com.example.administrator.sport.R;

import static com.example.administrator.sport.R.anim.left_out;
import static com.example.administrator.sport.R.anim.right_in;

/**
 * Created by Administrator on 2017/3/5.
 */

public class ShouCang extends BaseActivity {
    private ImageView imageView1,imageView2,imageView3,imageView4;
    private DB_C db_c;
    private RecylerViewAdapter_ShouCang recylerViewAdapter;
    private RecyclerView recyclerView;
    private LinearLayout linearLayout1,linearLayout2,linearLayout3;
    private FrameLayout frameLayout,frameLayout2;

    @Override
    public void addLayout() {
        setContentView(R.layout.shoucang);
    }

    @Override
    public void initView() {
        db_c=new DB_C(this);
        recyclerView= (RecyclerView) findViewById(R.id.recyleview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recylerViewAdapter=new RecylerViewAdapter_ShouCang(this);
        recylerViewAdapter.addList(db_c.show());
        recyclerView.setAdapter(recylerViewAdapter);
        imageView1= (ImageView) findViewById(R.id.iv22);
        imageView2= (ImageView) findViewById(R.id.iv23);
        frameLayout= (FrameLayout) findViewById(R.id.framLayout66);
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView1.setVisibility(View.INVISIBLE);
                imageView2.setVisibility(View.VISIBLE);

                finish();
                overridePendingTransition(left_out,right_in);
            }
        });
       imageView3= (ImageView) findViewById(R.id.iv30);
        imageView4= (ImageView) findViewById(R.id.iv31);
        frameLayout2= (FrameLayout) findViewById(R.id.frameLayout99);

        linearLayout3= (LinearLayout) findViewById(R.id.layout7);
//        linearLayout3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                frameLayout2.setVisibility(View.VISIBLE);
//                imageView3.setVisibility(View.INVISIBLE);
//                imageView4.setVisibility(View.VISIBLE);
//            }
//        });
        frameLayout2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                Log.e("msg","11111111");
//                frameLayout2.setBackgroundColor(0xffDDDDDD);
//                frameLayout2.setVisibility(View.GONE);
                db_c.delete(recylerViewAdapter.getList());
                 recylerViewAdapter.updateList(db_c.show());
                recyclerView.setAdapter(recylerViewAdapter);

// Log.e("dd",db_c.getList()+"");

//                Log.e("msg","22222");
//                imageView3.setVisibility(View.VISIBLE);
//                imageView4.setVisibility(View.INVISIBLE);


//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                frameLayout2.setBackgroundColor(0xff2b86db);


            }
        });

        recylerViewAdapter.setOnClickLintener(new RecylerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, String imgurl1, String imgur2, String imgur3, String title, String author, String date, String url) {
                Intent intent = new Intent(ShouCang.this, NewsPage.class);
                intent.putExtra("imgurl1",imgurl1);
                intent.putExtra("imgur2",imgur2);
                intent.putExtra("imgur3",imgur3);
                intent.putExtra("title",title);
                intent.putExtra("author",author);
                intent.putExtra("date",date);
                intent.putExtra("url",url);
                startActivity(intent);
                overridePendingTransition(R.anim.left_in,R.anim.left_out);
            }
        });
    }
}
