package com.cybertek.tests.day10_Sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitExample {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }


    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        //locate username inputbox - it is hidden but it is still in HTmL so we can locate find element
        WebElement usernameInputbox = driver.findElement(By.id("username"));
        //usernameInputbox.sendKeys("Mike"); // but we can not send keys because it is hidden!!!
        // first we should click start button
        driver.findElement(By.tagName("button")).click();

        // we need wait until element will be visiable!!
        // How to wait EXPLICITLY?
        // Create Explicit wait object
        WebDriverWait wait = new WebDriverWait(driver,10);

        // calling until methdo from wait object
        wait.until(ExpectedConditions.visibilityOf(usernameInputbox));
        // bunun yerine looding görünmez oluncaya kadar da denebilirdi invisiable..

        usernameInputbox.sendKeys("Mike Smith");
    }


    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        //click enable
        driver.findElement(By.xpath("(//button)[2]")).click();

        //finding inputbox
        WebElement inputBox = driver.findElement(By.xpath("(//input)[2]"));

        WebDriverWait wait = new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.elementToBeClickable(inputBox));
        inputBox.sendKeys("Mike Smith");

    }
}
