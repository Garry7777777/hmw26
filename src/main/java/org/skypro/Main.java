package org.skypro;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {

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

        //
        ClassPathXmlApplicationContext contextSingle =
                new ClassPathXmlApplicationContext("applicationContextSingle.xml");

        System.out.println("Car6 ещё не создан");
        var  car6 = contextSingle.getBean("someCar", Car.class);
        car6.go();

        contextSingle.close();



    }
}
