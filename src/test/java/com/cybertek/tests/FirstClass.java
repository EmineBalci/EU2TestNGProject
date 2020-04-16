package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


    }
}
