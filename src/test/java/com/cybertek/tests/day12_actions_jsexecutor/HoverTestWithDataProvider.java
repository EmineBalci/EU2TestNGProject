package com.cybertek.tests.day12_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HoverTestWithDataProvider {
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
    @DataProvider (name = "img_data")
    public Object[] aa(){
        Object [] datas = {1,2,3};
        return datas;
     // return {1,2,3};
    }

    @Test (dataProvider = "img_data")
    public void test1(Integer i) {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img;
        //verify name 1 by 1 / just do inside 1 loop
        Actions actions = new Actions(driver);

        WebElement name;

            img= driver.findElement(By.xpath("(//img)["+i+"]"));
            actions.moveToElement(img).perform();
            name = driver.findElement(By.xpath("(//h5)["+i+"]"));
            Assert.assertTrue(name.isDisplayed());
            Assert.assertEquals(name.getText(),"name: user"+i);


    }
}
