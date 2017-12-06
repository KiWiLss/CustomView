package com.magicsoft.customview.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.magicsoft.customview.R;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: ColorView2.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/6 10:45
 * @Changes (from 2017/12/6)
 * -----------------------------------------------------------------
 * 2017/12/6 : Create ColorView2.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class ColorView2 extends ImageView {//像素点处理图片


    private final Bitmap bitmap;
    private final int[] newPixels;
    private int width;
    private int height;
    private int[] oldPixels;

    public ColorView2(Context context) {
        this(context,null);
    }

    public ColorView2(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ColorView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.jj2);
        width = bitmap.getWidth();
        height = bitmap.getHeight();

        oldPixels = new int[width * height];
        newPixels = new int[width * height];
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //获取像素
        bitmap.getPixels(oldPixels,0,width,0,0,width,height);


    }
}
