package com.cybertek.tests.day12_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HoverTest {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

    // hover
    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img;
        WebElement name;
        //verify name 1 by 1 / just do inside 1 loop
        Actions actions = new Actions(driver);

        // img = driver.findElement(By.xpath("(//img)[1]"));
        // actions.moveToElement(img);
        // name = driver.findElement(By.xpath("(//h5)[1]"));
        // String actualName= name.getText();
        // String expectedName = "name: user1";
        // Assert.assertEquals(actualName,expectedName);

        for (int i=1; i<=3; i++){
            img = driver.findElement(By.xpath("(//img)["+i+"]"));
            actions.moveToElement(img);
            name = driver.findElement(By.xpath("(//h5)["+i+"]"));
            String actualName= name.getText();
            String expectedName = "name: user"+i;
        }




















//        for (int i=1; i<=3; i++){
//            img= driver.findElement(By.xpath("(//div/img)["+i+"]"));
//            actions.moveToElement(img).perform();
//            name = driver.findElement(By.xpath("(//div//h5[1])["+i+"]"));
//            Assert.assertTrue(name.isDisplayed());
//            Assert.assertEquals(name.getText(),"name: user"+i);
//        }
    }
}
