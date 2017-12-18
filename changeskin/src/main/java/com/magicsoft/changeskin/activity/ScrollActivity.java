package com.magicsoft.changeskin.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.magicsoft.changeskin.R;
import com.magicsoft.changeskin.utils.ScreenShot;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: ScrollActivity.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/18 15:41
 * @Changes (from 2017/12/18)
 * -----------------------------------------------------------------
 * 2017/12/18 : Create ScrollActivity.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class ScrollActivity extends AppCompatActivity {

    private LinearLayout mLl;
    private ImageView mImg;
    private ScrollView mSv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);

        mLl = (LinearLayout) findViewById(R.id.ll);
        mImg = (ImageView) findViewById(R.id.img);
        mSv = (ScrollView) findViewById(R.id.sv);


    }

    public void clickListener(View view) {
        Bitmap bitmap = ScreenShot.getBitmapByView(mSv);
        if (bitmap!=null){
            mImg.setImageBitmap(bitmap);
        }
    }
}
