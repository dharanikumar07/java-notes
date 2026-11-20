package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Alien obj = (Alien) context.getBean("alien2");
        obj.code();
        //from xml file
        System.out.println(obj.getAge());
        obj.getCom().code();
        
        //Laptop lap = (Laptop) context.getBean("lap");

       // Laptop lap = context.getBean(Laptop.class);
        // Computer com1 =  context.getBean(Computer.class); // it confused because computer has two implementation lap, desktop using primary it takes class
    }
}
