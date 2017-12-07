package com.magicsoft.customview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: FlagsView.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/7 14:47
 * @Changes (from 2017/12/7)
 * -----------------------------------------------------------------
 * 2017/12/7 : Create FlagsView.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class FlagsView extends ImageView {
    public FlagsView(Context context) {
        super(context);
    }

    public FlagsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FlagsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);




    }
}
