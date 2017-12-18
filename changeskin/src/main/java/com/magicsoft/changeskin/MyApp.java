package com.magicsoft.changeskin;

import android.app.Application;

import com.zhy.changeskin.SkinManager;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: MyApp.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/18 11:14
 * @Changes (from 2017/12/18)
 * -----------------------------------------------------------------
 * 2017/12/18 : Create MyApp.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SkinManager.getInstance().init(this);
    }
}
