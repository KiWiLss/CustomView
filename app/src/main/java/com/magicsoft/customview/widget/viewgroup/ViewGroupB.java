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

public class ViewGroupB extends LinearLayout {

    public static final String TAG="MMM";

    public ViewGroupB(Context context) {
        this(context,null);
    }

    public ViewGroupB(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ViewGroupB(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent:B "+event.getAction());
        return super.onTouchEvent(event);
        //return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG, "onInterceptTouchEvent: B"+ev.getAction() );
        return super.onInterceptTouchEvent(ev);
        //return true;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "dispatchTouchEvent: B"+ev.getAction() );
        return super.dispatchTouchEvent(ev);
    }
}
