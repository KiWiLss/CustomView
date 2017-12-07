package com.magicsoft.customview.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.magicsoft.customview.R;
import com.magicsoft.customview.utils.IconUtils;
import com.magicsoft.customview.widget.ColorView;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 *
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/6 9:24
 * @Changes (from 2017/12/6)
 * -----------------------------------------------------------------
 * 2017/12/6 : Create
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class Color extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape);
        float[]colorArray={0.33F,  0.59F,  0.11F,  0,  0,
                0.33F,  0.59F,  0.11F,  0,  0,
                0.33F,  0.59F,  0.11F,  0,  0,
                0,  0,  0,  1,  0  };//灰度矩阵
        float[]colorArray1={-1, 0,  0,  1,  1,
                0,  -1, 0,  1,  1,
                0,  0,  -1, 1,  1,
                0,  0,  0,  1,  0  };//图像翻转
        float[]colorArray2={0.393F, 0.769F, 0.189F, 0,  0,
                0.349F, 0.686F, 0.168F, 0,  0,
                0.272F, 0.534F, 0.131F, 0,  0,
                0,      0,      0,      1,  0  };//怀旧效果
        ColorView cv = (ColorView) findViewById(R.id.cv_color_icon);

        cv.setColorArray(colorArray2);

        ImageView viewById = (ImageView) findViewById(R.id.img_shape_iocn);
        Bitmap bitmap = IconUtils.handleImagePixelsRelief(BitmapFactory.decodeResource(getResources(), R.mipmap.jj2));
        viewById.setImageBitmap(bitmap);

    }
}
