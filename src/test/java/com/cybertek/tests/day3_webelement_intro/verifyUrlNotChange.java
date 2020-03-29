package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;

public class verifyUrlNotChange {
    public static void main(String[] args) {

        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        // save url before click
        String expected= driver.getCurrentUrl();

        // like as int String we use for web driver web element
        // Web Element: interface that represent elements on te webpage
        //findElement : method used to find element on waebpage
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        // retrievePasswordButton is data type of selenium libary. NOT OBJECT
        //click() : clicking web element..
        retrievePasswordButton.click();


        String actualUrl= driver.getCurrentUrl();

        //verify url not change
        if (expected.equals(actualUrl)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        driver.quit();

    }

}
