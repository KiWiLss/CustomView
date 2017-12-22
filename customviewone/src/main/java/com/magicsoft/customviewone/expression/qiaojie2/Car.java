package com.magicsoft.customviewone.expression.qiaojie2;

public abstract class Car {
    private ITire tire;

    public Car(ITire tire) {
        this.tire = tire;
    }

    public ITire getTire() {
        return tire;
    }

    public abstract void run();
}