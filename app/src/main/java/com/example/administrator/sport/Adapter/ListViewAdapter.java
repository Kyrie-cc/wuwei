package com.example.administrator.sport.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.sport.R;
import com.example.administrator.sport.bean.User;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2017/3/7.
 */

public class ListViewAdapter extends BaseAdapter {
   private ArrayList<User> list;
    private Context context;

    public ListViewAdapter(Context context,ArrayList<User> list ) {
        this.list=list;
        this.context=context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
class ViewHolder{
    private TextView textView;
    private ImageView imageView;
}
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder=null;
        if(view==null){

                view= LayoutInflater.from(context).inflate(R.layout.fragment4_son,null);
            holder=new ViewHolder();
            holder.textView= (TextView) view.findViewById(R.id.tv12);
            holder.imageView= (ImageView) view.findViewById(R.id.iv21);
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
         holder.textView.setText(list.get(position).getName());
        holder.imageView.setBackgroundResource(list.get(position).getImage());
        return view;
    }
}
