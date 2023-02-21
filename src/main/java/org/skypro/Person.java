package org.skypro;

public class Person {

    private final Car car;

    public Person(Car car) {
        this.car = car;
    }

    public void sitInCar(){
        System.out.println("Владелец сел в автомобиль");
        car.go();
    }

}
