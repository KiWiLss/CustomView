package com.magicsoft.customview.utils.paint;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: PaintUtils.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/7 15:46
 * @Changes (from 2017/12/7)
 * -----------------------------------------------------------------
 * 2017/12/7 : Create PaintUtils.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class PaintUtils {

    //@SuppressLint("NewApi")
    //@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static Bitmap circleRound(Bitmap bitmap){//画圆角图片
        //Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.jj2);

        Bitmap bp = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bp);
        Paint paint = new Paint();
        paint.setAntiAlias(true);

        canvas.drawRoundRect(0,0,bitmap.getWidth(),bitmap.getHeight(),80,80,paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return bp;
    }

    public static Bitmap getRoundCornerImage(Bitmap bitmap, int roundPixels)
    {
        //创建一个和原始图片一样大小位图
        Bitmap roundConcerImage = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        //创建带有位图roundConcerImage的画布
        Canvas canvas = new Canvas(roundConcerImage);
        //创建画笔
        Paint paint = new Paint();
        //创建一个和原始图片一样大小的矩形
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        // 去锯齿
        paint.setAntiAlias(true);
        //画一个和原始图片一样大小的圆角矩形
        canvas.drawRoundRect(rectF, roundPixels, roundPixels, paint);
        //设置相交模式
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        //把图片画到矩形去
        canvas.drawBitmap(bitmap, null, rect, paint);
        return roundConcerImage;
    }

    public static Bitmap scratchCard(Bitmap bitmap){//刮刮卡效果
        Paint paint = new Paint();
        /**
         * 将画笔的透明度设置为0，这样才能显示出擦除效果。
         * 在使用PorterDuffXfermode进行图层混合时，并不是简单地只进行图层的计算，同时也会计算透明通道的值。
         * 正是由于混合了透明通道，才形成了这样的效果。
         */
        paint.setAlpha(0);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        paint.setStyle(Paint.Style.STROKE);
        //使paint的笔触更加圆滑一点
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(50);
        //使paint的连接处更加圆滑
        paint.setStrokeCap(Paint.Cap.ROUND);

        Path path = new Path();
        Bitmap bp = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bp);
        canvas.drawColor(Color.GRAY);
        return bp;
    }




}
