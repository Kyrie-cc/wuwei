package com.example.administrator.sport.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.sport.Adapter.MyAdapter;
import com.example.administrator.sport.R;
import com.example.administrator.sport.activity.Add;
import com.example.administrator.sport.activity.ShouCang;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/27.
 */

public class Fragment1 extends Fragment {
private ViewPager viewPager;
    private MyAdapter myAdapter;
    private String[] names={"头条","社会","国内","国际","娱乐","体育","军事","科技","财经","时尚"};
    private TabLayout tabLayout;
    private  String[] names2={"top","shehui","guonei","guoji","yule","tiyu","junshi","keji","caijing","shishang"};
//    private String[] names={"头条","社会","国内","国际","娱乐"};
    private ImageView imageView;
    private LinearLayout linearLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment1,null);
        imageView= (ImageView) view.findViewById(R.id.iv9);
        linearLayout= (LinearLayout) view.findViewById(R.id.layout8);
        tabLayout= (TabLayout) view.findViewById(R.id.tablayout);
         myAdapter=new MyAdapter(getFragmentManager(),getdate(),names);
        viewPager= (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(myAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(getContext(), ShouCang.class);
//                startActivity(intent);
//            }
//        });
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Add.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.top_out,R.anim.anim);
            }
        });
        return view;
    }
    public ArrayList<Fragment> getdate(){
        ArrayList<Fragment> list=new ArrayList<>();
        for(int i=0;i<names.length;i++){
            Fragment fragment=new FragmentItem();
            Bundle bundle=new Bundle();
            bundle.putString("name",names2[i]);
            fragment.setArguments(bundle);
            list.add(fragment);
        }
         return list;
    }
}
