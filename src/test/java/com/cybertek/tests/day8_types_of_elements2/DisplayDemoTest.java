package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DisplayDemoTest {
    WebDriver driver = WebDriverFactory.getDriver("chrome");
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement usernameInput = driver.findElement(By.id("username"));

        System.out.println(usernameInput.isDisplayed());
        // verify that username not displayed on the screen
        Assert.assertFalse(usernameInput.isDisplayed(), "verify username not displayed on the screen");

        //click start button
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[1]")).click();
        Thread.sleep(5000);
        // verify that username not displayed on the screen
        Assert.assertTrue(usernameInput.isDisplayed(), "verify username  displayed on the screen");
    }


    @AfterMethod
    public void after(){
        driver.quit();
    }
}
