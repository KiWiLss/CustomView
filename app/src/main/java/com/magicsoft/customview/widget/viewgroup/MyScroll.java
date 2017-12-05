package com.magicsoft.customview.widget.viewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Scroller;

import com.magicsoft.customview.utils.ScreenUtils;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: MyScroll.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/4 17:41
 * @Changes (from 2017/12/4)
 * -----------------------------------------------------------------
 * 2017/12/4 : Create MyScroll.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class MyScroll extends ViewGroup {

    public static final String TAG = "MMM";
    private int screenHeight;
    private Scroller scroller;
    private int mLastY;
    private float mStart;

    public MyScroll(Context context) {
        this(context,null);
    }

    public MyScroll(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyScroll(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        screenHeight = ScreenUtils.getScreenHeight(context);
        initView(context);
    }

    private void initView(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        scroller = new Scroller(context);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        int childCount = getChildCount();
        //设置viewgroup的高度
        MarginLayoutParams lp = (MarginLayoutParams) getLayoutParams();
        lp.height = screenHeight * childCount;

        setLayoutParams(lp);
        for (int i4 = 0; i4 < childCount; i4++) {
            View childView = getChildAt(i4);
            if (childView.getVisibility() != View.GONE) {
                childView.layout(i, i4 * screenHeight, i2, (i4 + 1) * screenHeight);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastY=y;
                //记录触摸起点
                mStart = getScaleY();
                Log.e(TAG, "onTouchEvent: "+y+"||"+mStart );
                break;
            case MotionEvent.ACTION_MOVE:
                if (!scroller.isFinished()){
                    scroller.abortAnimation();
                }
                int dy=mLastY-y;
                if (getScaleY()<0){
                    dy=0;
                }
                if (getScaleY()>getHeight()-screenHeight){
                    dy=0;
                }
                scrollBy(0,dy);
                mLastY=y;
                break;
            case MotionEvent.ACTION_UP:
                int dScrollY=checkAlignment();
                if (dScrollY>0){
                    if (dScrollY<screenHeight/3){
                        scroller.startScroll(0,getScrollY(),0,-dScrollY);
                    }else {
                        scroller.startScroll(0,getScrollY(),0,screenHeight-dScrollY);
                    }

                }else {
                    if (-dScrollY<screenHeight/3){
                        scroller.startScroll(0,getScrollY(),0,-dScrollY);
                    }else {
                        scroller.startScroll(0,getScrollY(),0,-screenHeight-dScrollY);
                    }
                }
                break;
        }
        postInvalidate();
        return true;
    }
    private int checkAlignment() {
        int mEnd = getScrollY();
        boolean isUp = ((mEnd - mStart) > 0) ? true : false;
        int lastPrev = mEnd % screenHeight;
        int lastNext = screenHeight - lastPrev;
        if (isUp) {
            //向上的
            return lastPrev;
        } else {
            return -lastNext;
        }
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {//遍历子控件对其自身进行测量
            View childView = getChildAt(i);
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
        }

    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (scroller.computeScrollOffset()){
            scrollTo(0, scroller.getCurrY());
            postInvalidate();
        }
    }
}
