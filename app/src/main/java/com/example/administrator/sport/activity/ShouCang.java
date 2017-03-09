package com.example.administrator.sport.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.example.administrator.sport.Adapter.RecylerViewAdapter;
import com.example.administrator.sport.R;

/**
 * Created by Administrator on 2017/3/5.
 */

public class ShouCang extends BaseActivity {
    private ImageView imageView;
    private DB_C db_c;
    private RecylerViewAdapter recylerViewAdapter;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;
    @Override
    public void addLayout() {
        setContentView(R.layout.f);
    }

    @Override
    public void initView() {
        db_c=new DB_C(this);
        refreshLayout= (SwipeRefreshLayout) findViewById(R.id.swipeRefresh1);
        recyclerView= (RecyclerView) findViewById(R.id.recyleview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recylerViewAdapter=new RecylerViewAdapter(this);
        recylerViewAdapter.addList(db_c.show());
        recyclerView.setAdapter(recylerViewAdapter);


    }
}
