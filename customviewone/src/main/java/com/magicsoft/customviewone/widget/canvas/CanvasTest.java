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
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(40);     //为了实验效果明显，特地设置描边宽度非常大
        //画笔设置
        // 描边
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(200,200,100,paint);

// 填充
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(200,500,100,paint);

// 描边加填充
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(200, 800, 100, paint);



        //1,绘制颜色
        //canvas.drawColor(Color.YELLOW);

        //2,绘制圆点 在坐标(200,200)位置绘制一个点
//        canvas.drawPoint(200,200,mPaint);
//        //绘制一组点，坐标位置由float数组指定
//        canvas.drawPoints(new float[]{
//        300,300,300,400,300,500
//        }, mPaint);

        ////3, 在坐标(300,300)(500,600)之间绘制一条直线
//        canvas.drawLine(300,300,500,600,mPaint);
//        // 绘制一组线 每四数字(两个点的坐标)确定一条线
//        canvas.drawLines(new float[]{
//                300,300,400,300
//                ,400,500,500,500
//        },mPaint);
//
//        //4,绘制矩形
//        //方法一
//        canvas.drawRect(100,100,200,200,mPaint);
//        //方法二
//        canvas.drawRect(new Rect(100,250,200,300),mPaint);
//        //方法三
//        canvas.drawRect(new RectF(100,350,200,500),mPaint);

        //5,绘制圆角矩形
        //方法一,21以后才能用
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            canvas.drawRoundRect(100,100,500,200,30,30,mPaint);
//        }
//        //方法二
//        RectF rectF = new RectF(100, 100, 500, 200);
//        canvas.drawRoundRect(rectF,30,30,mPaint);
//        //利用两个半径参数绘制一个椭圆
//        // 矩形
        //RectF rectF = new RectF(100,100,600,400);

//// 绘制背景矩形
//        mPaint.setColor(Color.GRAY);
//        canvas.drawRect(rectF,mPaint);
//
//// 绘制圆角矩形
//        mPaint.setColor(Color.BLUE);
//        canvas.drawRoundRect(rectF,700,400,mPaint);
        //6,绘制椭圆
        //canvas.drawOval(100,100,600,300,mPaint);
//        RectF rectF = new RectF(100, 100, 600, 300);
//        canvas.drawOval(rectF,mPaint);
//
//        //7,绘制圆
//        canvas.drawCircle(400,600,200,mPaint);

        //8,绘制圆弧

//        RectF rectF = new RectF(100, 100, 600, 600);
//        canvas.drawRect(rectF,mPaint);
//        mPaint.setColor(Color.RED);
//        canvas.drawArc(rectF,0,90,true,mPaint);

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
