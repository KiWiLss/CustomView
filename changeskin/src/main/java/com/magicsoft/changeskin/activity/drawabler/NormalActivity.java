package com.magicsoft.changeskin.activity.drawabler;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.magicsoft.changeskin.R;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: NormalActivity.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/18 11:43
 * @Changes (from 2017/12/18)
 * -----------------------------------------------------------------
 * 2017/12/18 : Create NormalActivity.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class NormalActivity extends AppCompatActivity {

    public static final String TAG = "MMM";
    private DrawerLayout mDl;
    private Toolbar mTb;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);



            Window window = getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


        mDl = (DrawerLayout) findViewById(R.id.dl_normal_drawer);
        mTb = (Toolbar) findViewById(R.id.tb_normal_tb);

        setSupportActionBar(mTb);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDl, mTb, R.string.drawer_open, R.string.drawer_close);
        actionBarDrawerToggle.syncState();

        mDl.setDrawerListener(actionBarDrawerToggle);

        //监控抽屉
        mDl.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {



                View mContent = mDl.getChildAt(0);
                View mMenu = drawerView;

                int width = mMenu.getWidth();
                float scale = slideOffset * 1.0f / width;

               /* WindowManager wm = NormalActivity.this.getWindowManager();

                int width = wm.getDefaultDisplay().getWidth();
                int height = wm.getDefaultDisplay().getHeight();


                Resources resources = NormalActivity.this.getResources();
                DisplayMetrics dm = resources.getDisplayMetrics();
                float density = dm.density;
                int width2 = dm.widthPixels;
                int height2 = dm.heightPixels;

                Log.e(TAG, "onDrawerSlide: "+slideOffset+"||"+width+"||" +width2);
                //mContent.setTranslationX(width*slideOffset);

                mContent.layout(mMenu.getRight(), 0, mMenu.getRight() + dm.widthPixels, dm.heightPixels);*/

              /*  float scale = 1 - slideOffset;
                float rightScale = 0.8f + scale * 0.2f;



                if (drawerView.getTag().equals("LEFT")) {//带缩放效果

                    float leftScale = 1 - 0.3f * scale;

                    mMenu.setScaleX(leftScale);
                    mMenu.setScaleY(leftScale);
                    mMenu.setAlpha(0.6f + 0.4f * (1 - scale));
                    mContent.setTranslationX(mMenu.getMeasuredWidth() * (1 - scale));
                    mContent.setPivotX(0);
                    mContent.setPivotY(mContent.getMeasuredHeight() / 2);
                    mContent.invalidate();

                    mContent.setScaleX(rightScale);
                    mContent.setScaleY(rightScale);


                }
*/
            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }
}
