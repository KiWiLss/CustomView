package com.magicsoft.customview.activity.listview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.AbsListView;
import android.widget.ListView;

import com.magicsoft.customview.R;
import com.magicsoft.customview.adapter.ListViewAdapter;

import java.util.ArrayList;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: ListViewActivity.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/5 13:53
 * @Changes (from 2017/12/5)
 * -----------------------------------------------------------------
 * 2017/12/5 : Create ListViewActivity.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class ListViewActivity extends AppCompatActivity {

    private ListView mLv;
    private ArrayList<String> mData;
    private ListViewAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        mLv = (ListView) findViewById(R.id.lv_listview_list);

        mData = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            mData.add("hello"+i);
        }
        mAdapter = new ListViewAdapter(this, mData);
        mLv.setAdapter(mAdapter);

        mLv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });


    }
}
