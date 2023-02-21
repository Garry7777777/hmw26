package org.skypro;

public class Car {
    public Car() {
        System.out.println("Создан бин для Car");
    }

    public void go(){
        System.out.println("Автомобиль едет \n");
    }

    public void init(){
        System.out.println("Car.init \n");
    }

    public void destroy(){
        System.out.println("Car.destroy \n");
    }

}
