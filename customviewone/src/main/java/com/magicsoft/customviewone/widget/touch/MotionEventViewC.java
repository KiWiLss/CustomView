package com.magicsoft.customviewone.widget.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MotionEventViewC extends View {
    public MotionEventViewC(Context context) {
        super(context);
    }
    public MotionEventViewC(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public MotionEventViewC(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("MMM", "MotionEventViewC dispatchTouchEventC");
        return super.dispatchTouchEvent(ev);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("MMM", "MotionEventViewC onTouchEventC");
        return super.onTouchEvent(event);
    }
}