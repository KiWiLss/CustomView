package com.magicsoft.customviewone.widget.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2017/12/19
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class PictureCancas extends View {//画picture
    public PictureCancas(Context context) {
        this(context,null);
    }

    public PictureCancas(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PictureCancas(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        //调用录制方法
        recording();
    }

    // 1.创建Picture
    private Picture mPicture = new Picture();
    private void init(Context context) {



    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //开始绘制录制内容
        //方法一
        mPicture.draw(canvas);
    }

    /**
     * 录制方法
     */
    private void recording(){
        // 开始录制 (接收返回值Canvas)
        Canvas canvas = mPicture.beginRecording(500, 500);
        // 创建一个画笔
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);

        // 在Canvas中具体操作
        // 位移
        canvas.translate(250,250);
        // 绘制一个圆
        canvas.drawCircle(0,0,100,paint);

        mPicture.endRecording();

    }


}
