package com.example.administrator.sport.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.sport.Adapter.RecylerViewAdapter;
import com.example.administrator.sport.activity.Add;
import com.example.administrator.sport.activity.NewsPage;
import com.example.administrator.sport.bean.ItemBean;
import com.example.administrator.sport.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/2/28.
 */

public class FragmentItem extends Fragment {
    private Retrofit retrofit;
    private TextView textView;
    private String name;
    private RecyclerView recyclerView;
    private RecylerViewAdapter recylerViewAdapter;
    private SwipeRefreshLayout refreshLayout;
    private List<ItemBean.ResultBean.DataBean> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragmentitem,null);
        recyclerView= (RecyclerView) view.findViewById(R.id.recyleview);
        recylerViewAdapter=new RecylerViewAdapter(getContext());
        recyclerView.setAdapter(recylerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        name=getArguments().getString("name");
        refreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
        //设置下拉刷新的进度条颜色（最多四种）
        refreshLayout.setColorSchemeResources(R.color.colorAccent);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //显示进度条
                refreshLayout.setRefreshing(true);
                retrodfit(true);
                //当下拉时候完成的工作

                //最后需要隐藏进度条


            }
        });

        retrodfit(false);
//        recylerViewAdapter.setOnClickLintener(new RecylerViewAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Intent intent=new Intent(getContext(), NewsPage.class);
//                intent.putExtra("key",list.get(position).getUrl());
//                startActivity(intent);
////                Toast.makeText(getContext(), "TTT   "+position, Toast.LENGTH_SHORT).show();
//            }
//        });
        recylerViewAdapter.setOnClickLintener(new RecylerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, String imgurl1, String imgur2, String imgur3, String title, String author, String date, String url) {
                Intent intent = new Intent(getContext(), NewsPage.class);
                intent.putExtra("imgurl1",imgurl1);
                intent.putExtra("imgur2",imgur2);
                intent.putExtra("imgur3",imgur3);
                intent.putExtra("title",title);
                intent.putExtra("author",author);
                intent.putExtra("date",date);
                intent.putExtra("url",url);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.left_in,R.anim.left_out);

            }
        });



        return view;
    }
    private void retrodfit(final boolean isupdate){
        //1.初始化Retrofit
        //网址、解析工具（gosn等）
        //http://newapi.meipai.com/output/channels_topics_timeline.json?id=16
        final Retrofit retrofit = new Retrofit.Builder().
                baseUrl("http://v.juhe.cn/toutiao/").
                addConverterFactory(GsonConverterFactory.create())
                .build();
        //3.准备请求网络
        newsService service=retrofit.create(newsService.class);
        //4.通过回调获得结果
        Call<ItemBean> call=service.getBean(name,"8b41621da64fb5a7db660117a62cfa36");
        //5.请求加入调度，正式排队去网络获取数据
        call.enqueue(new Callback<ItemBean>() {


            @Override
            public void onResponse(Call<ItemBean> call, Response<ItemBean> response) {
//                Log.e("msg",response.body().getResult().getData().size()+"");
                 list=response.body().getResult().getData();
                 if(isupdate){
                     recylerViewAdapter.updateList(response.body().getResult().getData());
                     refreshLayout.setRefreshing(false);
                     Toast.makeText(getContext(), "更新成功！", Toast.LENGTH_SHORT).show();
                 }else {

                     recylerViewAdapter.addList(response.body().getResult().getData());
                     Toast.makeText(getContext(), "更新失败！", Toast.LENGTH_SHORT).show();
                 }
            }

            @Override
            public void onFailure(Call<ItemBean> call, Throwable t) {
                refreshLayout.setRefreshing(false);
            }
        });
    }


    //定义接口
    public interface newsService{
        @GET("index")
        Call<ItemBean> getBean(@Query("type") String type,@Query("key") String key);
    }

}
