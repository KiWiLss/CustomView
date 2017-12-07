package com.magicsoft.customview.widget.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: CircleView.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/7 16:40
 * @Changes (from 2017/12/7)
 * -----------------------------------------------------------------
 * 2017/12/7 : Create CircleView.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class CircleView extends ImageView {
    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.jj2);
//        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
//        Paint paint = new Paint();
//        //用一张图片创建一支具有图像填充功能的画笔，并使用这只画笔绘制一个圆形
//        paint.setShader(bitmapShader);
//        canvas.drawCircle(500, 250, 200, paint);

//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
//        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
//        Paint paint = new Paint();
//        paint.setShader(bitmapShader);
//        canvas.drawCircle(500, 250, 200, paint);

        Paint paint = new Paint();
        paint.setShader(new LinearGradient(0,0,400,400, Color.RED,Color.BLUE, Shader.TileMode.REPEAT));

        canvas.drawRect(0, 0, 400, 400, paint);
    }
}
