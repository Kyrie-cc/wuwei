package com.example.administrator.sport.activity;

import android.content.Intent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.administrator.sport.R;
import com.example.administrator.sport.bean.ItemBean;
import com.example.administrator.sport.bean.User;
import com.example.administrator.sport.fragment.FragmentItem;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMWeb;

/**
 * Created by Administrator on 2017/3/2.
 */

public class NewsPage extends BaseActivity {
    private WebView webView;
    private ProgressBar progressBar;
    private ImageView imageView1,imageView2,imageView3,imageView4,imageView5;
    private FrameLayout frameLayout;
    private DB_C db_c;
    @Override
    public void addLayout() {
   setContentView(R.layout.news_page);
    }

    @Override
    public void initView() {
        db_c=new DB_C(this);
        webView= (WebView) findViewById(R.id.wv);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        imageView3= (ImageView) findViewById(R.id.iv17);
        imageView4= (ImageView) findViewById(R.id.iv20);
        imageView5= (ImageView) findViewById(R.id.iv16);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        final Intent intent=getIntent();
        final String url=intent.getStringExtra("url");
        final String img1=intent.getStringExtra("imgurl1");
        final String img2=intent.getStringExtra("imgur2");
        final String img3=intent.getStringExtra("imgur3");
        final String title=intent.getStringExtra("title");
        final String author=intent.getStringExtra("author");
        final String date=intent.getStringExtra("date");
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);

                return true;
            }
        });
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if(newProgress==100){
                    progressBar.setVisibility(view.INVISIBLE);
                }else{
                    if(view.INVISIBLE==progressBar.getVisibility()){
                        progressBar.setVisibility(view.VISIBLE);
                    }
                    progressBar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
        imageView1= (ImageView) findViewById(R.id.iv15);
         imageView2= (ImageView) findViewById(R.id.iv16);
         imageView3= (ImageView) findViewById(R.id.iv17);

        frameLayout= (FrameLayout) findViewById(R.id.framLayout666);
//         frameLayout.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//                  imageView1.setVisibility(View.INVISIBLE);
//                 imageView2.setVisibility(View.VISIBLE);
//                 Intent intent1=new Intent(NewsPage.this, FragmentItem.class);
//                 startActivity(intent1);
//             }
//         });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (db_c.show() == null) {
                    db_c.add(img1, img2, img3, url, author, date, title);
                    Toast.makeText(NewsPage.this, "收藏成功！", Toast.LENGTH_SHORT).show();
                } else {
                    for (ItemBean.ResultBean.DataBean u : db_c.show()) {
                        if (u.getUrl().equals(url) && u.getTitle().equals(title)) {
                            Toast.makeText(NewsPage.this, "该新闻已收藏！", Toast.LENGTH_SHORT).show();
                            return;
                        }
//                else {

//
                    }
                    db_c.add(img1, img2, img3, url, author, date, title);
//
//                    }
//                    db_c.add(img1, img2, img3, title, author, date, url);
                    Toast.makeText(NewsPage.this, "收藏成功！", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        设置分享
        final UMWeb web = new UMWeb(url);
                web.setTitle(title);//标题
//                web.setThumb(img1);  //缩略图
                web.setDescription("Mr.Wu分享");//描述
//        new ShareAction(NewsPage.this)

//                .share()
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new ShareAction(NewsPage.this)
                        .withMedia(web)

                        .setDisplayList(SHARE_MEDIA.QZONE,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.QQ)
                        .setCallback(new UMShareListener() {
                            @Override
                            public void onStart(SHARE_MEDIA share_media) {
                                Toast.makeText(NewsPage.this, "开始了！", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onResult(SHARE_MEDIA share_media) {
                                Toast.makeText(NewsPage.this, "结果了！", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                                Toast.makeText(NewsPage.this, "出错了！", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCancel(SHARE_MEDIA share_media) {
                                Toast.makeText(NewsPage.this, "取消了！", Toast.LENGTH_SHORT).show();
                            }
                        }).open();
            }
        });
//NewsPage页面finish()到FragmentItem页面
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView1.setVisibility(View.INVISIBLE);
                imageView5.setVisibility(View.VISIBLE);
                finish();

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

//    返回键设置
    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            super.onBackPressed();
        }

    }

}
