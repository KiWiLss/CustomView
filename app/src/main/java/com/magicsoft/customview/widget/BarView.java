package com.magicsoft.customview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: BarView.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/4 16:29
 * @Changes (from 2017/12/4)
 * -----------------------------------------------------------------
 * 2017/12/4 : Create BarView.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class BarView extends View {

    public static final String TAG="MMM";
    private Paint mPiant;
    private int offset = 5;
    private int mRectCount=12;
    private int mRectWidth;


    public BarView(Context context) {
        this(context,null);
    }

    public BarView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }
    double random;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();
        mPiant = new Paint();
        mPiant.setColor(Color.RED);
        mPiant.setStyle(Paint.Style.FILL);
        mRectWidth = (int) (width * 0.6 / mRectCount);
        //canvas.drawRect(10,50,300,300,mPiant);

        for (int i = 0; i < mRectCount; i++) {
            random = Math.random();
            //随机的高度
            float currentHeight = (float) (height * random);
            Log.e(TAG, "onDraw: *****"+currentHeight+"||"+random);
            canvas.drawRect((float) (width*0.4/2+mRectWidth*i+offset),
                    currentHeight,
                    (float) (width*0.4/2+mRectWidth*(i+1)),height,mPiant);

        }
        postInvalidateDelayed(500);
    }
}
