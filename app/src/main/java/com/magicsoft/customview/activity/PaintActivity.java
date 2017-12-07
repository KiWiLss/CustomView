package com.magicsoft.customview.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.magicsoft.customview.R;
import com.magicsoft.customview.utils.paint.PaintUtils;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: PaintActivity.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/7 15:19
 * @Changes (from 2017/12/7)
 * -----------------------------------------------------------------
 * 2017/12/7 : Create PaintActivity.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class PaintActivity extends AppCompatActivity {

    private ImageView mImgOne;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
        initView();

        initBitmap();

    }

    private void initBitmap() {
        Bitmap bitmap = PaintUtils.circleRound(BitmapFactory.decodeResource(getResources(), R.mipmap.jj2));
        mImgOne.setImageBitmap(bitmap);
    }

    private void initView() {
        mImgOne = (ImageView) findViewById(R.id.img_paint_one);
    }
}
