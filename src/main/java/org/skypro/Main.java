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
        car.go();

        var  person  = context.getBean("somePerson", Person.class);
        person.sitInCar();

        context.close();


    }
}
