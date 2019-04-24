package springioc.class003.human;

import springioc.class003.car.Car;

public class ZhangSan extends HumanWithCar {

    public ZhangSan(Car car) {
        super(car);
    }

    @Override
    public void goHome() {
        car.start();
        car.turnLeft();
        car.turnRight();
        car.stop();
    }
}
