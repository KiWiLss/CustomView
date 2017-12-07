package com.magicsoft.customview.utils;

import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2016, by your company, All rights reserved.
 * -----------------------------------------------------------------
 *
 * @File: IconUtils.java
 * @Author: winding.kiwi.lss
 * @Version: V100R001C01
 * @Create: 2017/12/7 14:28
 * @Changes (from 2017/12/7)
 * -----------------------------------------------------------------
 * 2017/12/7 : Create IconUtils.java (winding);
 * -----------------------------------------------------------------
 * @description ${DESCRIPTION}
 */

public class IconUtils {
    public static Bitmap handleImageNegative(Bitmap bm) {

        //返回的就是像素点个数
        int width = bm.getWidth();
        int height = bm.getHeight();

        //用于存储当前取出来的颜色
        int color;

        //用于保存颜色中取出来的四个分量
        int r, g, b ,a;

        Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        //保存像素点数组到图像
        int[] oldPx = new int[width * height];

        int[] newPx = new int[width * height];

        //第三个参数 stride 多少个算一行 一般为width
        bm.getPixels(oldPx, 0, width, 0, 0, width, height);

        for (int i = 0; i < width * height; i++) {
            color = oldPx[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);

            r = 255 - r;
            g = 255 - g;
            b = 255 - b;

            if (r > 255) {
                r = 255;
            } else if (r < 0) {
                r = 0;
            }

            if (g > 255) {
                g = 255;
            } else if (g < 0) {
                g = 0;
            }

            if (b > 255) {
                b = 255;
            } else if (b < 0) {
                b = 0;
            }

            newPx[i] = Color.argb(a, r, g, b);

        }

        bmp.setPixels(newPx, 0, width, 0, 0, width, height);

        return bmp;
    }

    /**
     * 怀旧效果
     *
     * 求像素点的老照片效果算法
     * newR = (int) (0.393 * pixR + 0.769 * pixG + 0.189 * pixB);
     * newG = (int) (0.349 * pixR + 0.686 * pixG + 0.168 * pixB);
     * newB = (int) (0.272 * pixR + 0.534 * pixG + 0.131 * pixB);
     *
     * @param bm
     * @return
     */
    public static Bitmap handleImagePixelOldPhoto(Bitmap bm) {

        int width = bm.getWidth();
        int height = bm.getHeight();

        int color = 0;

        int r, g, b, a, r1, b1, g1;

        Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        int[] oldPx = new int[width * height];
        int[] newPx = new int[width * height];

        bm.getPixels(oldPx, 0, width, 0, 0, width, height);

        for (int i = 0; i < width * height; i++) {
            color = oldPx[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);

            r1 = (int) (0.393 * r + 0.769 * g + 0.189 * b);
            g1 = (int) (0.349 * r + 0.686 * g + 0.168 * b);
            b1 = (int) (0.272 * r + 0.534 * g + 0.131 * b);

            if (r1 > 255) {
                r1 = 255;
            }

            if (g1 > 255) {
                g1 = 255;
            }

            if (b1 > 255) {
                b1 = 255;
            }

            newPx[i] = Color.argb(a, r1, g1, b1);

        }

        bmp.setPixels(newPx, 0, width, 0, 0, width, height);

        return bmp;

    }

    /**
     * 浮雕效果
     *
     * ABC
     * 求B点的浮雕效果算法：
     * B.r = C.r - B.r + 127
     * B.g = C.g - B.g + 127
     * B.r = C.b - B.b + 127
     *
     * @param bm
     * @return
     */
    public static Bitmap handleImagePixelsRelief(Bitmap bm) {

        int width = bm.getWidth();
        int height = bm.getHeight();

        int color = 0;
        int colorBefore = 0;

        int r, g, b, a;

        int r1, b1, g1;

        int oldPx[] = new int[width * height];
        int newPx[] = new int[width * height];

        Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        bm.getPixels(oldPx, 0, width, 0, 0, width, height);

        //注意要从1开始！！！
        for (int i = 1; i < width * height; i++) {

            colorBefore = oldPx[i - 1];
            a = Color.alpha(colorBefore);
            r = Color.red(colorBefore);
            g = Color.green(colorBefore);
            b = Color.blue(colorBefore);

            color = oldPx[i];

            r1 = Color.red(color);
            g1 = Color.green(color);
            b1 = Color.blue(color);

            r = r - r1 + 127;
            g = g - g1 + 127;
            b = b - b1 + 127;

            if (r > 255) {
                r = 255;
            }

            if (g > 255) {
                g = 255;
            }

            if (b > 255) {
                b = 255;
            }

            newPx[i] = Color.argb(a, r, g, b);

        }

        bmp.setPixels(newPx, 0, width, 0, 0, width, height);

        return bmp;

    }
}
