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
 * @File: MeterView.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/5 15:56
 * @Changes (from 2017/12/5)
 * -----------------------------------------------------------------
 * 2017/12/5 : Create MeterView.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class MeterView extends View {

    public static final String TAG="MMM";

    public MeterView(Context context) {
        super(context);
    }

    public MeterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MeterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e(TAG, "onDraw: " );
        //画外圆
        Paint circlePaint = new Paint();
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setColor(Color.BLACK);
        circlePaint.setAntiAlias(true);
        circlePaint.setStrokeWidth(5);
        canvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()/2-3,circlePaint);
        //画刻度
        Paint paintDegree = new Paint();
        paintDegree.setStrokeWidth(3);
        for (int i = 0; i < 24; i++) {
            //区分整点和非整点
            if (i==0||i==6||i==12||i==18){
                paintDegree.setStrokeWidth(5);
                paintDegree.setTextSize(30);
                //画线
                canvas.drawLine(getWidth()/2,getHeight()/2-getWidth()/2,getWidth()/2,getHeight()/2-getWidth()/2+50,paintDegree);
                //画数字,每个数字都在线条的下方一定的距离
                String degree = String.valueOf(i);
                float v = paintDegree.measureText(degree);
                Log.e("MMM", "onDraw: "+v+"||"+i);
                canvas.drawText(degree,getWidth()/2-v/2,getHeight()/2-getWidth()/2+90,paintDegree);

            }else {
                paintDegree.setStrokeWidth(3);
                paintDegree.setTextSize(15);

                canvas.drawLine(getWidth()/2,getHeight()/2-getWidth()/2,getWidth()/2,getHeight()/2-getWidth()/2+30,paintDegree);
                String degree = String.valueOf(i);
                float v = paintDegree.measureText(degree);
                //Log.e("MMM", "onDraw: "+v+"||"+i);
                canvas.drawText(degree,getWidth()/2-v/2,getHeight()/2-getWidth()/2+60,paintDegree);
            }
            //通过旋转画布,简化坐标计算
            canvas.rotate(15,getWidth()/2,getHeight()/2);

        }
        //画指针
        Paint paintHour = new Paint();
        paintHour.setStyle(Paint.Style.STROKE);
        paintHour.setAntiAlias(true);
        paintHour.setStrokeWidth(20);

        Paint paintMinute = new Paint();
        paintMinute.setStyle(Paint.Style.STROKE);
        paintMinute.setAntiAlias(true);
        paintMinute.setStrokeWidth(10);

        canvas.save();

        canvas.translate(getWidth()/2,getHeight()/2);
        canvas.drawLine(0,0,100,100,paintHour);
        canvas.drawLine(0,0,100,150,paintMinute);
        canvas.restore();
    }
}
