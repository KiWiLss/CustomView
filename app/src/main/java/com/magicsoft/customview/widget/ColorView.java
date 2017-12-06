package com.magicsoft.customview.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
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
 * @File: ColorView.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/6 10:04
 * @Changes (from 2017/12/6)
 * -----------------------------------------------------------------
 * 2017/12/6 : Create ColorView.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class ColorView extends ImageView {//使用颜色矩阵改变图片效果
    private Bitmap bitmap;
    private float[] colorArray  = {1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0};

    public ColorView(Context context) {
        this(context,null);
    }

    public ColorView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.jj2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        //描画,原始图片
        canvas.drawBitmap(bitmap,0,0,paint);
        //新建颜色矩阵对象
        ColorMatrix colorMatrix = new ColorMatrix();
        //设置颜色矩阵的值
        colorMatrix.set(colorArray);
        //设置画笔颜色过滤器
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        //描画,处理后的图片
        canvas.drawBitmap(bitmap,0,0,paint);
        invalidate();

    }

    //设置颜色数值
    public void setColorArray(float[] colorArray){
        this.colorArray = colorArray;
    }
    //设置图片
    public void setBitmap(Bitmap bitmap){
        this.bitmap = bitmap;
    }
}
