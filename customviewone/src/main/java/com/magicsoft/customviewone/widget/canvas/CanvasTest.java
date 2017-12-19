package com.magicsoft.customviewone.widget.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
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


public class CanvasTest extends View {

    public static final String TAG = "MMM";
    private Paint mPaint;

    public CanvasTest(Context context) {
        this(context,null);
    }

    public CanvasTest(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CanvasTest(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);       //设置画笔颜色
        mPaint.setStyle(Paint.Style.FILL);  //设置画笔模式为填充
        mPaint.setStrokeWidth(5f);         //设置画笔宽度为10px
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //1,绘制颜色
        //canvas.drawColor(Color.YELLOW);

        //2,绘制圆点 在坐标(200,200)位置绘制一个点
//        canvas.drawPoint(200,200,mPaint);
//        //绘制一组点，坐标位置由float数组指定
//        canvas.drawPoints(new float[]{
//        300,300,300,400,300,500
//        }, mPaint);

        ////3, 在坐标(300,300)(500,600)之间绘制一条直线
        canvas.drawLine(300,300,500,600,mPaint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);


        Log.e(TAG, "onMeasure: "+width+"|"+widthMode+"***"+height+"||"+heightMode);
    }
}
