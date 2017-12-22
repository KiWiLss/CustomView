package com.magicsoft.customviewone.widget.touch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class MotionEventViewGroupA extends LinearLayout {
    public MotionEventViewGroupA(Context context) {
        super(context);
    }
    public MotionEventViewGroupA(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public MotionEventViewGroupA(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
 @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("MMM", "MotionEventViewGroupA dispatchTouchEventA");
        return super.dispatchTouchEvent(ev);
    }
    
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("MMM", "MotionEventViewGroupA onInterceptTouchEventA");
        return super.onInterceptTouchEvent(ev);
        //return true;
    }
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("MMM", "MotionEventViewGroupA onTouchEventA");
        return super.onTouchEvent(event);
    }
}