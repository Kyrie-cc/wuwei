package com.example.administrator.sport.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.sport.Adapter.ListViewAdapter;
import com.example.administrator.sport.R;
import com.example.administrator.sport.activity.ShouCang;
import com.example.administrator.sport.bean.User;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/27.
 */

public class Fragment4 extends Fragment {
    private ListViewAdapter listViewAdapter;
    private TextView textView;
    private ListView listView;
    private ArrayList<User> list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment4,null);
        listView= (ListView) view.findViewById(R.id.listView);
        listViewAdapter=new ListViewAdapter(getContext(),getList());
        listView.setAdapter(listViewAdapter);
        intent();
        return view;

    }
    public void intent(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       if(position==2){
           Intent intent =new Intent(getContext(), ShouCang.class);
                startActivity(intent);
           getActivity().overridePendingTransition(R.anim.left_in,R.anim.left_out);
       }
            }
        });
    }
    public ArrayList<User> getList(){
        list=new ArrayList<>();
        list.add(new User("我的消息",R.drawable.nnn));
        list.add(new User("我的关注",R.drawable.nnn));
        list.add(new User("我的收藏",R.drawable.nnn));
        list.add(new User("我的评论",R.drawable.nnn));
        list.add(new User("投诉反馈",R.drawable.nnn));
        list.add(new User("游戏",R.drawable.nnn));

        return list;
    }
}
