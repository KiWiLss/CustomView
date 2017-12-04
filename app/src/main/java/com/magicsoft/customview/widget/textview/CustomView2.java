package com.magicsoft.customview.widget.textview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: CustomView2.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/4 11:58
 * @Changes (from 2017/12/4)
 * -----------------------------------------------------------------
 * 2017/12/4 : Create CustomView2.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class CustomView2 extends TextView {//渐变和闪烁的文字
    private int mMeasureWidth;
    private TextPaint mPaint;
    private LinearGradient mLinearGradient;
    private Matrix mMatrix;
    private int mTranslate;

    public CustomView2(Context context) {
        this(context,null);
    }

    public CustomView2(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mMeasureWidth == 0) {
            mMeasureWidth = getMeasuredWidth();
            if (mMeasureWidth>0){
                mPaint = getPaint();
                mLinearGradient = new LinearGradient(0, 0, mMeasureWidth, 0,
                        new int[]{Color.BLUE, Color.YELLOW, Color.RED}, null, Shader.TileMode.CLAMP);
                mPaint.setShader(mLinearGradient);
                mMatrix = new Matrix();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mMatrix!=null){

            mTranslate+=mMeasureWidth/5;

            if (mTranslate>2*mMeasureWidth){

                mTranslate=-mMeasureWidth;
            }
            mMatrix.setTranslate(mTranslate,0);
            mLinearGradient.setLocalMatrix(mMatrix);
            postInvalidateDelayed(100);
        }

    }
}
