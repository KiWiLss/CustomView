package com.magicsoft.customview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.magicsoft.customview.utils.DensityUtils;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: CircelView.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/4 15:21
 * @Changes (from 2017/12/4)
 * -----------------------------------------------------------------
 * 2017/12/4 : Create CircelView.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class CircelView extends View {

    public static final String TAG="MMM";
    private int mCircelXY;
    private double mRadius;
    Context mContext;

    public CircelView(Context context) {
        this(context,null);
    }

    public CircelView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CircelView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext=context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        Paint circlePaint = new Paint();
        circlePaint.setColor(Color.RED);
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setAntiAlias(true);

        Paint arcPaint = new Paint();
        arcPaint.setColor(Color.YELLOW);
        arcPaint.setStyle(Paint.Style.STROKE);
        arcPaint.setStrokeWidth(20);

        Paint textPaint = new Paint();
        textPaint.setColor(Color.BLUE);
        textPaint.setAntiAlias(true);
        float textSize= DensityUtils.getInstance().dp2px(mContext,15);
        textPaint.setTextSize(textSize);


        Paint centerPaint = new Paint();
        centerPaint.setColor(Color.BLACK);
        canvas.drawPoint(mCircelXY,mCircelXY,centerPaint);

        mCircelXY=getWidth()/2;
        mRadius = getWidth() * 0.5 / 2;
        Log.e(TAG, "onDraw: "+getWidth()+"||"+mCircelXY );
        //绘制圆
        canvas.drawCircle(mCircelXY,mCircelXY, (float) mRadius,circlePaint);
        RectF rectF = new RectF((float) (width * 0.1), (float) (width * 0.1), (float) (width * 0.9), (float) (width * 0.9));

        //绘制弧线
        canvas.drawArc(rectF,270,200,false,arcPaint);
        String showText="显示文字";
        //绘制文字
        canvas.drawText(showText,0,showText.length(),mCircelXY-(textSize),mCircelXY+(textSize/4),textPaint);

    }
}
