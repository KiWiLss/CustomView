package com.magicsoft.customviewone.widget.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class MotionEventViewGroupB extends LinearLayout {
    public MotionEventViewGroupB(Context context) {
        super(context);
    }
    public MotionEventViewGroupB(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public MotionEventViewGroupB(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
 @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("MMM", "MotionEventViewGroupB dispatchTouchEventB");
        return super.dispatchTouchEvent(ev);
    }
    
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("MMM", "MotionEventViewGroupB onInterceptTouchEventB");
        return super.onInterceptTouchEvent(ev);
        //return true;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("MMM", "MotionEventViewGroupB onTouchEventB");
        //return super.onTouchEvent(event);
        return true;
    }
}