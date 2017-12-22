package com.magicsoft.customviewone.expression.qiaojie2;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2017/12/22
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class Client {
    public static void main(String[] args) {

        Car car = null;
        int i = 4;
        for (int j = 0; j < i; j++) {

            switch (j) {
                case 0:
                    car = new SedanCar(new RainyTire());
                    break;
                case 1:
                    car = new SedanCar(new SandyTire());
                    break;
                case 2:
                    car = new RacingCar(new RainyTire());
                    break;
                case 3:
                    car = new RacingCar(new SandyTire());
                    break;
            }
            car.run();
        }

    }
}
