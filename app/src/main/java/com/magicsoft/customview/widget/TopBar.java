package com.magicsoft.customview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.magicsoft.customview.R;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: TopBar.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/4 14:37
 * @Changes (from 2017/12/4)
 * -----------------------------------------------------------------
 * 2017/12/4 : Create TopBar.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class TopBar extends RelativeLayout {
    public static final String TAG="MMM";
    private final String title;
    private int mTitleColor;
    private float mTitleSize;
    private String mLeftText;
    private int mLeftColor;
    private Drawable mLeftBackground;
    private float mLeftSize;
    private String mRihgtText;
    private float mRightSize;
    private Drawable mRightBackground;
    private TextView mTitleText;
    private Button mLeftBtn;
    private Button mRightBtn;
    private LayoutParams mLeftParams;
    private LayoutParams mRightParams;
    private LayoutParams mTitleParams;
    private topBarClickListener tbcl;

    public TopBar(Context context) {
        this(context,null);
    }

    public TopBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TopBar);

        //获取所有的属性值
         title = ta.getString(R.styleable.TopBar_title);
        mTitleColor = ta.getColor(R.styleable.TopBar_titleTextColor, Color.BLACK);
        mTitleSize = ta.getDimension(R.styleable.TopBar_titleTextSize, 10);

        mLeftText = ta.getString(R.styleable.TopBar_leftText);
        //mLeftColor = ta.getColor(R.styleable.TopBar_leftTextColor, Color.BLACK);
        mLeftBackground = ta.getDrawable(R.styleable.TopBar_leftBackground);
        mLeftSize = ta.getDimension(R.styleable.TopBar_leftTextSize, 10);

        mRihgtText = ta.getString(R.styleable.TopBar_rightText);
        mRightSize = ta.getDimension(R.styleable.TopBar_rightTextSize, 10);
        mRightBackground = ta.getDrawable(R.styleable.TopBar_rightBackground);

        ta.recycle();

        mTitleText = new TextView(context);
        mLeftBtn = new Button(context);
        mRightBtn = new Button(context);

        //为创建的组元素赋值
        mRightBtn.setText(mRihgtText);
        mRightBtn.setTextSize(mRightSize);
        //Log.e(TAG, "TopBar: "+mRightSize+"||"+DensityUtils.getInstance().dp2px(context,mRightSize) );
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mRightBtn.setBackground(mRightBackground);
        }

        mLeftBtn.setText(mLeftText);
        mLeftBtn.setTextSize(mLeftSize);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mLeftBtn.setBackground(mLeftBackground);
        }

        mTitleText.setText(title);
        mTitleText.setTextColor(mTitleColor);
        mTitleText.setTextSize(mTitleSize);
        mTitleText.setGravity(Gravity.CENTER);

        //为组件元素设置相应的布局元素
        mLeftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        //添加到viewgroup
        addView(mLeftBtn,mLeftParams);

        mRightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        addView(mRightBtn,mRightParams);

        mTitleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        addView(mTitleText,mTitleParams);

        //两边的点击事件
        mLeftBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                tbcl.leftClick();
            }
        });
        mRightBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                tbcl.rightClick();
            }
        });
    }

    //对外暴露点击事件
    public void setOnTopBarClickListener(topBarClickListener tbcl){
        this.tbcl=tbcl;
    }



    public interface topBarClickListener{
        void rightClick();
        void leftClick();
    }
}
