package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagNameLocator {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInputBox = driver.findElement(By.tagName("input"));
        fullNameInputBox.sendKeys("Mike Smithhhhhhh");
        Thread.sleep(2000);

       WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("asd@asd.com");
        Thread.sleep(1000);

        driver.findElement(By.tagName("button")).click();
        Thread.sleep(2000);

        String actualMessage = driver.findElement(By.tagName("h3")).getText();
        System.out.println("actualMessage = " + actualMessage);

        driver.quit();


    }
}
