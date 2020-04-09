package com.cybertek.tests;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class FirstClass {
    public static void main(String[] args) {

        int a = (int)Math.PI;

        System.out.println("hi"+ a);

        Faker faker = new Faker();
        System.out.println(faker.name().fullName());
        System.out.println(faker.harryPotter().character());
        System.out.println(faker.animal().name());
        System.out.println(faker.finance().creditCard(CreditCardType.VISA));

        System.out.println("hi");
        System.out.println("hi"); //cntrl + d  copy line



    }
}
