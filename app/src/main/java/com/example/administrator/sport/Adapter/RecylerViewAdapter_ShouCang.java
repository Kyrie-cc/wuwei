package com.example.administrator.sport.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.sport.R;
import com.example.administrator.sport.bean.ItemBean;
import com.example.administrator.sport.bean.People;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/9.
 */

public class RecylerViewAdapter_ShouCang  extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<People> list;
    Context context;
    public RecylerViewAdapter_ShouCang(Context context) {
        this.list = new ArrayList<>();
        this.context=context;
    }

    public RecylerViewAdapter_ShouCang(List<People> list, Context context) {
        this.list = list;
        this.context = context;
    }

    //添加数据
    public void addList(List<People> list) {
        Log.e("mm",list.size()+"");
        if (this.list.containsAll(list)) {
            return;
        }

        this.list.addAll(list);
        notifyDataSetChanged();
    }

    //更新数据
    public void updateList(List<People> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder holder = null;
//        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_son1, null);
//        holder = new MyViewHolder(view);
//        if (viewType == 1) {
//            view= LayoutInflater.from(parent.getContext())
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shoucang_son1, parent,false);
            holder = new RecylerViewAdapter_ShouCang.MyViewHolder(view);
//        } else if (viewType == 2||viewType==3) {
//            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shoucang_son1, parent,false);
//            holder = new RecylerViewAdapter_ShouCang.MyViewHolder3(view);
//        }
        return holder;
    }
//
//    @Override
//    public int getItemViewType(int position) {
//int i=1;
//     if(list.get(position).getThumbnail_pic_s02()!=null&&!list.get(position).getThumbnail_pic_s02().equals(" ")){
//         i++;
//     }
//        if(list.get(position).getThumbnail_pic_s03()!=null&&!list.get(position).getThumbnail_pic_s03().equals(" ")){
//            i++;
//        }
//return i;
//    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                listener.onItemClick(v,position,);
                if(listener!=null){
                    listener.onItemClick(v,position,list.get(position).getImg1(),
                            list.get(position).getImg2(), list.get(position).getImg3(),
                            list.get(position).getTitle(), list.get(position).getAuthor(),
                            list.get(position).getDate(), list.get(position).getUrl());
                }
            }
        });
        if (holder instanceof RecylerViewAdapter_ShouCang.MyViewHolder) {
            final RecylerViewAdapter_ShouCang.MyViewHolder holder1 = (RecylerViewAdapter_ShouCang.MyViewHolder) holder;
            holder1.textView1.setText(list.get(position).getTitle());
            holder1.textView2.setText(list.get(position).getDate());
            holder1.textView3.setText(list.get(position).getAuthor());

            Picasso.with(context).load(list.get(position).getImg1()).into(holder1.imageView1);
            holder1.checkBox.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       list.get(position).setCheck(!list.get(position).isCheck());
                       holder1.checkBox.setChecked(list.get(position).isCheck());
                       Log.e("msg111",list.get(position).isCheck()+"");
                   }
               });
        }else {
//            RecylerViewAdapter_ShouCang.MyViewHolder3 holder2 = (RecylerViewAdapter_ShouCang.MyViewHolder3) holder;
//            holder2.textView1.setText(list.get(position).getTitle());
//            holder2.textView2.setText(list.get(position).getDate());
//            holder2.textView3.setText(list.get(position).getAuthor_name());
//
//            Picasso.with(context).load(list.get(position).getThumbnail_pic_s()).into(holder2.imageView1);
//            Picasso.with(context).load(list.get(position).getThumbnail_pic_s02()).into(holder2.imageView2);
//            Picasso.with(context).load(list.get(position).getThumbnail_pic_s03()).into(holder2.imageView3);
//            holder2.checkBox.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    list.get(position).setCheck(!list.get(position).isCheck());
//                }
//            });
        }
    }

    public List<People> getList(){
       List<People> newList =new ArrayList<>();
        newList=this.list;
        return newList;
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
          private TextView textView1,textView2,textView3;
        private ImageView imageView1,imageView2,imageView3;
        private CheckBox checkBox;
        private LinearLayout linearLayout1;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView1= (TextView) itemView.findViewById(R.id.tv13);
            textView2= (TextView) itemView.findViewById(R.id.tv14);
            textView3= (TextView) itemView.findViewById(R.id.tv15);
            imageView1= (ImageView) itemView.findViewById(R.id.iv26);
            checkBox= (CheckBox) itemView.findViewById(R.id.checkBox1);

        }
    }
//    class MyViewHolder3 extends RecyclerView.ViewHolder{
//        private TextView textView1,textView2,textView3;
//        private ImageView imageView1,imageView2,imageView3;
//        private CheckBox checkBox;
//
//        public MyViewHolder3(View itemView) {
//            super(itemView);
//            textView1= (TextView) itemView.findViewById(R.id.tv16);
//            textView2= (TextView) itemView.findViewById(R.id.tv17);
//            textView3= (TextView) itemView.findViewById(R.id.tv18);
//            imageView1= (ImageView) itemView.findViewById(R.id.iv27);
//            imageView2= (ImageView) itemView.findViewById(R.id.iv28);
//            imageView3= (ImageView) itemView.findViewById(R.id.iv29);
//           checkBox= (CheckBox) itemView.findViewById(R.id.checkBox2);
//
//        }
//    }


    //    回调
    private RecylerViewAdapter.OnItemClickListener listener;
    public void setOnClickLintener(RecylerViewAdapter.OnItemClickListener lintener){
        this.listener=lintener;
    }
    //    接口准备完毕
    public  interface OnItemClickListener{
        void onItemClick(View view,int position,String imgurl1, String imgur2, String imgur3,
                         String title, String author,String date,String url);


    }
//    private List<ItemBean.ResultBean.DataBean> list;
//    private Context context;
//    private LinearLayout linearLayout1,linearLayout2;
//
//    public RecylerViewAdapter_ShouCang(Context context) {
//        this.list = new ArrayList<>();
//        this.context = context;
//    }
////    添加数据
//    public void addList(List<ItemBean.ResultBean.DataBean> list){
//        if(this.list.containsAll(list)){
//            return;
//        }
//     this.list.addAll(list);
//        notifyDataSetChanged();
//    }
////     更新数据
//    public void updateList(){
//        this.list=list;
//        notifyDataSetChanged();
//    }
//
//
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view;
//        RecyclerView.ViewHolder holder=null;
//        if(viewType==1){
//            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.shoucang_son1,parent,false);
////            linearLayout1= (LinearLayout) view.findViewById(R.id.layout5);
//            holder=new MyViewHolder(view);
//        }else if(viewType==2){
//            view=LayoutInflater.from(parent.getContext()).inflate(R.layout.shoucang_son2,parent,false);
////            linearLayout2= (LinearLayout) view.findViewById(R.id.layout6);
//            holder=new MyViewHolder2(view);
//
//        }
//        return null;
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        if(list.get(position).getThumbnail_pic_s()!=null&&list.get(position).getThumbnail_pic_s02()==null
//                &&list.get(position).getThumbnail_pic_s03()==null){
//
//            return 1;
//        }else if(list.get(position).getThumbnail_pic_s()==null&&list.get(position).getThumbnail_pic_s02()!=null
//                &&list.get(position).getThumbnail_pic_s03()==null){
//            return 1;
//        }else if( list.get(position).getThumbnail_pic_s()==null&&list.get(position).getThumbnail_pic_s02()==null
//                &&list.get(position).getThumbnail_pic_s03()!=null){
//            return 1;
//        }else  if(list.get(position).getThumbnail_pic_s()!=null&&list.get(position).getThumbnail_pic_s02()!=null
//                &&list.get(position).getThumbnail_pic_s03()!=null){
//            return 2;
//        }else if(list.get(position).getThumbnail_pic_s()!=null&&list.get(position).getThumbnail_pic_s02()!=null
//                &&list.get(position).getThumbnail_pic_s03()==null){
//            return 2;
//        }else if(list.get(position).getThumbnail_pic_s()!=null&&list.get(position).getThumbnail_pic_s02()==null
//                &&list.get(position).getThumbnail_pic_s03()!=null){
//            return 2;
//        }else if (list.get(position).getThumbnail_pic_s()==null&&list.get(position).getThumbnail_pic_s02()!=null
//                &&list.get(position).getThumbnail_pic_s03()!=null){
//            return 2;
//        }else {
//            return 2;
//        }
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
////           holder.itemView.setOnClickListener(new View.OnClickListener() {
////               @Override
////               public void onClick(View v) {
////                   if(listener!=null){
////                       listener.onItem(v,position,linearLayout1,linearLayout2);
////                   }
////               }
////           });
//           if(holder instanceof MyViewHolder){
//               MyViewHolder holder1= (MyViewHolder) holder;
//               holder1.textView1.setText(list.get(position).getTitle());
//               holder1.textView2.setText(list.get(position).getDate());
//               holder1.textView3.setText(list.get(position).getAuthor_name());
//               holder1.checkBox.setOnClickListener(new View.OnClickListener() {
//                   @Override
//                   public void onClick(View v) {
//                       list.get(position).setCheck(!list.get(position).isCheck());
//                   }
//               });
////              问题  当加载布局一的时候应该加载哪张图片
//               Picasso.with(context).load(list.get(position).getThumbnail_pic_s()).into(holder1.imageView1);
//           }else{
//               MyViewHolder2 holder2= (MyViewHolder2) holder;
//               holder2.textView1.setText(list.get(position).getTitle());
//               holder2.textView2.setText(list.get(position).getDate());
//               holder2.textView3.setText(list.get(position).getAuthor_name());
//               Picasso.with(context).load(list.get(position).getThumbnail_pic_s()).into(holder2.imageView1);
//               Picasso.with(context).load(list.get(position).getThumbnail_pic_s02()).into(holder2.imageView2);
//               Picasso.with(context).load(list.get(position).getThumbnail_pic_s03()).into(holder2.imageView3);
//               holder2.checkBox.setOnClickListener(new View.OnClickListener() {
//                   @Override
//                   public void onClick(View v) {
//                       list.get(position).setCheck(!list.get(position).isCheck());
//                   }
//               });
//           }
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//    class MyViewHolder extends RecyclerView.ViewHolder{
//          private TextView textView1,textView2,textView3;
//        private ImageView imageView1,imageView2,imageView3;
//        private CheckBox checkBox;
//        private LinearLayout linearLayout1;
//        public MyViewHolder(View itemView) {
//            super(itemView);
//            textView1= (TextView) itemView.findViewById(R.id.tv13);
//            textView2= (TextView) itemView.findViewById(R.id.tv14);
//            textView3= (TextView) itemView.findViewById(R.id.tv15);
//            imageView1= (ImageView) itemView.findViewById(R.id.iv26);
//            checkBox= (CheckBox) itemView.findViewById(R.id.checkBox1);
//
//        }
//    }
//    class MyViewHolder2 extends RecyclerView.ViewHolder{
//        private TextView textView1,textView2,textView3;
//        private ImageView imageView1,imageView2,imageView3;
//        private CheckBox checkBox;
//
//        public MyViewHolder2(View itemView) {
//            super(itemView);
//            textView1= (TextView) itemView.findViewById(R.id.tv16);
//            textView2= (TextView) itemView.findViewById(R.id.tv17);
//            textView3= (TextView) itemView.findViewById(R.id.tv18);
//            imageView1= (ImageView) itemView.findViewById(R.id.iv27);
//            imageView2= (ImageView) itemView.findViewById(R.id.iv28);
//            imageView3= (ImageView) itemView.findViewById(R.id.iv29);
//           checkBox= (CheckBox) itemView.findViewById(R.id.checkBox2);
//
//        }
//    }
// private OnItemClickListener listener;
//    public void setOnClickListener(OnItemClickListener listener){
//        this.listener=listener;
//    }
//    public interface OnItemClickListener{
//        void onItem(View v,int position,LinearLayout linearLayout1,LinearLayout linearLayout2);
//
//
//    }
}
