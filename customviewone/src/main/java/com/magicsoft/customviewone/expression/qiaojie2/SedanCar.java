package com.magicsoft.customviewone.expression.qiaojie2;

import android.util.Log;

public class SedanCar extends Car{
    public SedanCar(ITire tire) {
        super(tire);
    }

    @Override
    public void run() {
        //Log.e("shawn", "sedan car " + getTire().run());
        //System.out.println(getTire().run());
        Log.e("MMM", "sedan car  run: "+getTire().run() );
    }
}