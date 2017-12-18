package com.magicsoft.changeskin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.magicsoft.changeskin.R;
import com.magicsoft.changeskin.activity.drawabler.NormalActivity;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: ListActivity.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/18 11:35
 * @Changes (from 2017/12/18)
 * -----------------------------------------------------------------
 * 2017/12/18 : Create ListActivity.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

    }

    public void normal(View view) {
        startActivity(new Intent(this, NormalActivity.class));
    }

    public void webview(View view) {
        startActivity(new Intent(this, WebActivity.class));
    }

    public void scrollview(View view) {
        startActivity(new Intent(this, ScrollActivity.class));
    }
}
