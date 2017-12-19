package com.magicsoft.customviewone.widget.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
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
    public CanvasTest(Context context) {
        this(context,null);
    }

    public CanvasTest(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CanvasTest(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);



    }
}
