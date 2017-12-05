package com.magicsoft.customview.widget.viewgroup;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: ViewGroupA.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/5 11:04
 * @Changes (from 2017/12/5)
 * -----------------------------------------------------------------
 * 2017/12/5 : Create ViewGroupA.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class ViewGroupA extends LinearLayout {

    public static final String TAG="MMM";

    public ViewGroupA(Context context) {
        this(context,null);
    }

    public ViewGroupA(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ViewGroupA(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent:A "+event.getAction());
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG, "onInterceptTouchEvent:A "+ev.getAction() );
        return super.onInterceptTouchEvent(ev);
        //return true;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "dispatchTouchEvent: A"+ev.getAction() );
        return super.dispatchTouchEvent(ev);
    }
}
