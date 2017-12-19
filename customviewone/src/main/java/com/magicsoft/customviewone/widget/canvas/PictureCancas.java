package com.magicsoft.customviewone.widget.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Picture;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.magicsoft.customviewone.R;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2017/12/19
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class PictureCancas extends View {
    private Bitmap bitmap;
    private Paint mPaint;

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
        //recording();
    }

    // 1.创建Picture
    private Picture mPicture = new Picture();
    private void init(Context context) {

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.skin_main_bg);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    /*    //开始绘制录制内容
        //方法一,PS：这种方法在比较低版本的系统上绘制后可能会影响Canvas状态，所以这种方法一般不会使用。
        //mPicture.draw(canvas);
        //方法二
        //canvas.drawPicture(mPicture,new RectF(0,0,mPicture.getWidth(),200));*/

        //方法一
        canvas.drawBitmap(bitmap,100,100,mPaint);

        //方法二
        canvas.drawBitmap(bitmap,new Matrix(),mPaint);
    }

  /*  *//**
     * 录制方法
     *//*
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
*/

}
