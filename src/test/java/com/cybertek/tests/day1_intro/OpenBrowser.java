package com.cybertek.tests.day1_intro;


import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.swing.*;
import javax.xml.transform.sax.SAXSource;

public class OpenBrowser {
    public static void main(String[] args) {

        // hey webDriverMAnager, can u prepare chore for automation
        WebDriverManager.chromedriver().setup();
        // it is open empty chrome browser
        WebDriver driver = new ChromeDriver();
        // it is open what ever u type
        driver.get("https://cybertekschool.com");

        System.out.println("test test");

//        //firefox navigation
//
//        WebDriverManager.firefoxdriver().setup();
//
//        WebDriver driver = new FirefoxDriver();
//
//        driver.get("https://amazon.com");


        driver.quit();


    }

}
