package com.magicsoft.customview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.magicsoft.customview.R;

import java.util.List;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: ListViewAdapter.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/5 14:00
 * @Changes (from 2017/12/5)
 * -----------------------------------------------------------------
 * 2017/12/5 : Create ListViewAdapter.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class ListViewAdapter extends BaseAdapter {
    private final LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<String>mData;

    public ListViewAdapter(Context mContext, List<String> mData) {
        this.mContext = mContext;
        this.mData = mData;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view==null) {
            view=mLayoutInflater.inflate(R.layout.item_listview,viewGroup,false);
            viewHolder=new ViewHolder();
            viewHolder.tv=view.findViewById(R.id.tv_item_listvie_text);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.tv.setText(mData.get(i));
        return view;
    }

    public class ViewHolder{
        public TextView tv;
    }
}
