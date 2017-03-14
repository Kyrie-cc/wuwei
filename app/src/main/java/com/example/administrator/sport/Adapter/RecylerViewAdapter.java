package com.example.administrator.sport.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.sport.R;
import com.example.administrator.sport.bean.ItemBean;

import java.util.ArrayList;
import java.util.List;
import  com.example.administrator.sport.bean.ItemBean.ResultBean;
import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2017/3/1.
 */

public class RecylerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ResultBean.DataBean> list;
    Context context;
    public RecylerViewAdapter(Context context) {
        this.list = new ArrayList<>();
        this.context=context;
    }

    // TODO: 2017/3/14  

    //添加数据
    public void addList(List<ResultBean.DataBean> list) {
        Log.e("mm",list.size()+"");
        if (this.list.containsAll(list)) {
            return;
        }

        this.list.addAll(list);
        notifyDataSetChanged();
    }

    //更新数据
    public void updateList(List<ResultBean.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder holder = null;
//        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_son1, null);
//        holder = new MyViewHolder(view);
        if (viewType == 1) {
//            view= LayoutInflater.from(parent.getContext())
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_son1, null);
            holder = new MyViewHolder(view);
        } else if (viewType == 2) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_son2, null);
            holder = new MyViewHolder3(view);
        }
        return holder;
    }

    @Override
    public int getItemViewType(int position) {

        if(list.get(position).getThumbnail_pic_s()!=null&&list.get(position).getThumbnail_pic_s02()==null
                &&list.get(position).getThumbnail_pic_s03()==null){

            return 1;
        }else if(list.get(position).getThumbnail_pic_s()==null&&list.get(position).getThumbnail_pic_s02()!=null
                &&list.get(position).getThumbnail_pic_s03()==null){
            return 1;
        }else if( list.get(position).getThumbnail_pic_s()==null&&list.get(position).getThumbnail_pic_s02()==null
                &&list.get(position).getThumbnail_pic_s03()!=null){
            return 1;
        }else  if(list.get(position).getThumbnail_pic_s()!=null&&list.get(position).getThumbnail_pic_s02()!=null
                &&list.get(position).getThumbnail_pic_s03()!=null){
            return 2;
        }else if(list.get(position).getThumbnail_pic_s()!=null&&list.get(position).getThumbnail_pic_s02()!=null
                &&list.get(position).getThumbnail_pic_s03()==null){
            return 2;
        }else if(list.get(position).getThumbnail_pic_s()!=null&&list.get(position).getThumbnail_pic_s02()==null
                &&list.get(position).getThumbnail_pic_s03()!=null){
            return 2;
        }else if (list.get(position).getThumbnail_pic_s()==null&&list.get(position).getThumbnail_pic_s02()!=null
                &&list.get(position).getThumbnail_pic_s03()!=null){
            return 2;
        }else {
            return 2;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                listener.onItemClick(v,position,);
                if(listener!=null){
                    listener.onItemClick(v,position,list.get(position).getThumbnail_pic_s(),
                            list.get(position).getThumbnail_pic_s02(), list.get(position).getThumbnail_pic_s03(),
                            list.get(position).getTitle(), list.get(position).getAuthor_name(),
                            list.get(position).getDate(), list.get(position).getUrl());
                }
            }
        });
        if (holder instanceof MyViewHolder) {
            MyViewHolder holder1 = (MyViewHolder) holder;
            holder1.textView.setText(list.get(position).getTitle());
            holder1.textView2.setText(list.get(position).getDate());
            holder1.textView3.setText(list.get(position).getAuthor_name());

            Picasso.with(context).load(list.get(position).getThumbnail_pic_s()).into(holder1.imageView);
        }else {
            MyViewHolder3 holder2 = (MyViewHolder3) holder;
            holder2.textView.setText(list.get(position).getTitle());
            holder2.textView2.setText(list.get(position).getDate());
            holder2.textView3.setText(list.get(position).getAuthor_name());

            Picasso.with(context).load(list.get(position).getThumbnail_pic_s()).into(holder2.imageView1);
            Picasso.with(context).load(list.get(position).getThumbnail_pic_s02()).into(holder2.imageView2);
            Picasso.with(context).load(list.get(position).getThumbnail_pic_s03()).into(holder2.imageView3);
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView,textView2,textView3;
        ImageView imageView,imageView4;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView2= (TextView) itemView.findViewById(R.id.tv6);
            textView = (TextView) itemView.findViewById(R.id.tv7);
            textView3= (TextView) itemView.findViewById(R.id.tv8);
            imageView = (ImageView) itemView.findViewById(R.id.iv13);

        }
    }

    class MyViewHolder3 extends RecyclerView.ViewHolder {
        TextView textView,textView2,textView3;
        ImageView imageView1, imageView2, imageView3,imageView4;

        public MyViewHolder3(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.tv9);
            textView3= (TextView) itemView.findViewById(R.id.tv11);
            textView2= (TextView) itemView.findViewById(R.id.tv10);
            imageView1= (ImageView) itemView.findViewById(R.id.iv10);
            imageView2= (ImageView) itemView.findViewById(R.id.iv11);
            imageView3= (ImageView) itemView.findViewById(R.id.iv12);


        }
    }


//    回调
    private OnItemClickListener listener;
    public void setOnClickLintener(OnItemClickListener lintener){
        this.listener=lintener;
    }
//    接口准备完毕
    public  interface OnItemClickListener{
        void onItemClick(View view,int position,String imgurl1, String imgur2, String imgur3,
                         String title, String author,String date,String url);


}
}