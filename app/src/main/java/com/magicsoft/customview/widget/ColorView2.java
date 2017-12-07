package com.magicsoft.customview.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
    private int color;
    private int pixelsA;
    private int pixeisR;
    private int pixeisG;
    private int pixeisB;
    private Paint mPaint;
    Bitmap bmp;

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
        mPaint = new Paint();
        oldPixels = new int[width * height];
        newPixels = new int[width * height];
         bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //获取像素
        bitmap.getPixels(oldPixels,0,width,0,0,width,height);

        for (int i = 0; i < width * height; i++) {
            color = oldPixels[i];
            //获取r,g,b分量
            pixelsA = Color.alpha(color);
            pixeisR = Color.red(color);
            pixeisG = Color.green(color);
            pixeisB = Color.blue(color);
            //转换
            pixeisR=(255-pixeisR);
            pixeisG=(255-pixeisG);
            pixeisB=(255-pixeisB);
            //均小于等于255大于等于0
            if (pixeisR>255){
                pixeisR=255;
            }else  if (pixeisR<0){
                pixeisR=0;
            }

            if (pixeisG>255){
                pixeisG=255;
            }else  if (pixeisG<0){
                pixeisG=0;
            }

            if (pixeisB>255){
                pixeisB=255;
            }else if (pixeisB<0){
                pixeisB=0;
            }
            //根据新的RGB生成新像素
            newPixels[i] = Color.argb(pixelsA, pixeisR, pixeisG, pixeisB);
            //Log.e(TAG, "onDraw: "+newPixels[i] );

        }

        //根据新像素生成新图片
        bmp.setPixels(newPixels,0,width,0,0,width,height);
        canvas.drawBitmap(bmp,0,0,mPaint);
    }
}
