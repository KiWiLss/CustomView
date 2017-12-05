package com.magicsoft.customview.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.magicsoft.customview.R;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: LayerTest.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/5 17:11
 * @Changes (from 2017/12/5)
 * -----------------------------------------------------------------
 * 2017/12/5 : Create LayerTest.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class LayerTest extends View{


    private Paint mPaint;

    public LayerTest(Context context) {
        super(context);
    }

    public LayerTest(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LayerTest(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint = new Paint();
//        canvas.drawColor(Color.WHITE);
//
//        canvas.drawCircle(100,100,100,mPaint);
//
        //canvas.saveLayerAlpha(0,0,400,400,127,175);
//
        canvas.drawColor(Color.GREEN);

        //canvas.saveLayer(0, 0, 1000, 1000, mPaint, Canvas.ALL_SAVE_FLAG);
        canvas.translate(100, 100);
        Bitmap mDstB = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        canvas.drawBitmap(mDstB, 0, 0, mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
        canvas.drawBitmap(mDstB, 150, 150, mPaint);
        mPaint.setXfermode(null);
        canvas.restore();
    }
}
