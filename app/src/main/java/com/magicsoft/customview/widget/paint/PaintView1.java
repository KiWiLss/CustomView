package com.magicsoft.customview.widget.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

import com.magicsoft.customview.R;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: PaintView1.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/7 15:39
 * @Changes (from 2017/12/7)
 * -----------------------------------------------------------------
 * 2017/12/7 : Create PaintView1.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class PaintView1 extends ImageView {//刮刮图效果
    private Paint mPaint;//
    private Path mPath;
    private Bitmap mBgBitmap;
    private Bitmap mFgBitmap;
    private Canvas mCanvas;

    public PaintView1(Context context) {
        super(context);
        initAll();
    }

    public PaintView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAll();
    }

    public PaintView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAll();
    }

    private void initAll() {
        mPaint = new Paint();
        /**
         * 将画笔的透明度设置为0，这样才能显示出擦除效果。
         * 在使用PorterDuffXfermode进行图层混合时，并不是简单地只进行图层的计算，同时也会计算透明通道的值。
         * 正是由于混合了透明通道，才形成了这样的效果。
         */
        mPaint.setAlpha(0);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        mPaint.setStyle(Paint.Style.STROKE);
        //使Paint的笔触更加圆滑一点
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeWidth(50);
        //使Paint的连接处更加圆滑一点
        mPaint.setStrokeCap(Paint.Cap.ROUND);

        mPath = new Path();
        mBgBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.jj2);
        mFgBitmap = Bitmap.createBitmap(mBgBitmap.getWidth(), mBgBitmap.getHeight(), Bitmap.Config.ARGB_8888);

        mCanvas = new Canvas(mFgBitmap);
        mCanvas.drawColor(Color.GRAY);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(mBgBitmap, 0, 0, null);
        canvas.drawBitmap(mFgBitmap, 0, 0, null);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.reset();
                mPath.moveTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(event.getX(), event.getY());
                break;
        }
        //使用DST_IN模式将路径绘制到前面覆盖的图层上
        mCanvas.drawPath(mPath, mPaint);
        invalidate();
        return true;
    }
}
