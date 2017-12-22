package com.magicsoft.customviewone.expression.qiaojie2;

public class RacingCar extends Car{
    public RacingCar(ITire tire) {
        super(tire);
    }

    @Override
    public void run() {
        //Log.e("shawn", "racing car " + getTire().run());
        System.out.println(getTire().run());
    }
}