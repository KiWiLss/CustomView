package com.magicsoft.customview.widget.textview;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: CenterTv.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/4 16:21
 * @Changes (from 2017/12/4)
 * -----------------------------------------------------------------
 * 2017/12/4 : Create CenterTv.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class CenterTv extends TextView {
    public CenterTv(Context context) {
        this(context,null);
    }

    public CenterTv(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CenterTv(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


    }
}
