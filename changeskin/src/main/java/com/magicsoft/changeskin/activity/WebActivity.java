package com.magicsoft.changeskin.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import com.magicsoft.changeskin.R;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: WebActivity.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/18 14:44
 * @Changes (from 2017/12/18)
 * -----------------------------------------------------------------
 * 2017/12/18 : Create WebActivity.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class WebActivity extends AppCompatActivity {

    private ImageView mImg;
    private WebView mWv;
    private final String url = "http://v.pptv.com/show/hly7OaEHd7WiaFX7kVA.html?rcc_id=wap_144";
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView.enableSlowWholeDocumentDraw();

        setContentView(R.layout.activity_web);

        mImg = (ImageView) findViewById(R.id.img);
        mWv = (WebView) findViewById(R.id.wv);


        mWv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        mWv.getSettings().setJavaScriptEnabled(true);
        mWv.loadUrl(url);


    }
    //webView 截图
    private Bitmap captureScreenforRecord(WebView webView){

        float scale = webView.getScale();
        int webViewHeight = (int) (webView.getContentHeight()*scale);
        Bitmap bm = Bitmap.createBitmap(webView.getWidth(),webViewHeight, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bm);
        webView.draw(canvas);
        webView.measure(View.MeasureSpec.makeMeasureSpec(
                View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        webView.layout(0, 0, webView.getMeasuredWidth(),
                webView.getMeasuredHeight());
        webView.setDrawingCacheEnabled(true);
        webView.buildDrawingCache();

//        Bitmap bm = Bitmap.createBitmap(webView.getMeasuredWidth(),
//                webView.getMeasuredHeight(), Bitmap.Config.RGB_565);

        Canvas bigcanvas = new Canvas(bm);
        Paint paint = new Paint();
        int iHeight = bm.getHeight();
        bigcanvas.drawBitmap(bm, 0, iHeight, paint);
        webView.draw(bigcanvas);
        return  bm;
    }

    /**
     * 对WebView进行截屏，虽然使用过期方法，但在当前Android版本中测试可行
     *
     * @param webView
     * @return
     */
    private  Bitmap captureWebViewKitKat(WebView webView) {
        Picture picture = webView.capturePicture();
        int width = picture.getWidth();
        int height = picture.getHeight();
        if (width > 0 && height > 0) {
            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmap);
            picture.draw(canvas);
            return bitmap;
        }
        return null;
    }

    private Bitmap captureWebViewLollipop(WebView webView) {
        float scale = webView.getScale();
        int width = webView.getWidth();
        int height = (int) (webView.getContentHeight() * scale + 0.5);
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        webView.draw(canvas);
        return bitmap;
    }

//    private static Bitmap captureX5WebViewUnsharp(Context context, WebView webView) {
//        if (webView == null) {
//            return null;
//        }
//        if (context == null) {
//            context = webView.getContext();
//        }
//        int width = webView.getContentWidth();
//        int height = webView.getContentHeight();
//        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
//        Canvas canvas = new Canvas(bitmap);
//        webView.getX5WebViewExtension().snapshotWholePage(canvas, false, false);
//        return bitmap;
//    }



    public void open(View view) {
        Bitmap bitmap;
        Toast.makeText(WebActivity.this, "***", Toast.LENGTH_SHORT).show();
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

            bitmap=captureWebViewLollipop(mWv);
        }else {
            bitmap = captureWebViewKitKat(mWv);
        }
        if (bitmap!=null){
            mImg.setImageBitmap(bitmap);
            Log.e("MMM", "onClick: ***"+(bitmap==null) );
        }else {
            Log.e("MMM", "onClick: null" );
        }
    }
}
