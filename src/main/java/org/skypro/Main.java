package org.skypro;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//
//1. Создайте maven-проект с архетипом maven-archetype-quickstart, добавьте в файл pom.xml зависимость spring-context.
//2. Создайте папку resources, а в ней файл applicationContext и добавьте в него скрипт.
//3. Создайте класс Car с методом go, который выводит в консоль “Автомобиль едет”.
//4. Реализуйте Инверсию управления для этого класса и вызовите метод бина в методе main.
//5. Добавьте класс Person с методом, в котором будет выводиться строка “Владелец сел в автомобиль” и вызываться метод автомобиля.
//6. Реализуйте внедрение зависимостей в двух новых конфиг-файлах и вызовите метод объекта Person в новых классах.
//7. Назначьте в новых конфиг-файлах бинам класса Car scope singleton и prototype. Создайте по 2 объекта в новых классах и сравните их.
//8. Создайте в классе Car init и destroy методы, укажите эти методы в конфиг-файлах со скоупами. Реализуйте вызов этих методов (если это возможно).
//

public class Main
{
    public static void main( String[] args )
    {
        // задачи 1,2,3,4,5
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        var  car = context.getBean("someCar", Car.class);
        var  car2 = context.getBean("someCar", Car.class);
        car.go();

        var  person  = context.getBean("somePerson", Person.class);
        person.sitInCar();

        System.out.println(car==car2);
        System.out.println(car + "  " + car2);

        context.close(); System.out.println("-------------------------------------------");

        // задачи 6,8
        ClassPathXmlApplicationContext contextProto =
                new ClassPathXmlApplicationContext("applicationContextProto.xml");

        var  car3 = contextProto.getBean("someCar", Car.class);
        var  car4 = contextProto.getBean("someCar", Car.class);

        System.out.println(car3==car4);
        System.out.println(car3 + "  " + car4);


        var  car5 = contextProto.getBean("someCar", Car.class);
        car5.go();
        System.out.println("вызов Car5.destroy");
        car5.destroy();

        contextProto.close(); System.out.println("-------------------------------------------");

        // задачи 7,8
        ClassPathXmlApplicationContext contextSingle =
                new ClassPathXmlApplicationContext("applicationContextSingle.xml");

        System.out.println("Car6 ещё не создан");
        var  car6 = contextSingle.getBean("someCar", Car.class);
        car6.go();

        contextSingle.close();
    }
}
