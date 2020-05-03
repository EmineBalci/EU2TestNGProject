package com.cybertek.tests.day12_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.rmi.activation.ActivationID;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class ActionsTest {

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

    @Test
    public void hoverTest() {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img = driver.findElement(By.tagName("img"));

        //Actions -- class that contains all the user interactions
        // how to create object / passin driver as a constractor
        Actions actions = new Actions(driver);

        // perform() -- perform action, complete the action
        // moveToElement() -- move your mouse to webelement / hover over
        actions.moveToElement(img).perform();

        WebElement link = driver.findElement(By.linkText("View profile"));
        Assert.assertTrue(img.isDisplayed());
      
    }

    @Test
    public void DragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
       // WebDriverWait wait = new WebDriverWait(driver,20);
        Thread.sleep(4000);
     //   WebElement cookies =  driver.findElement(By.xpath("//*[.='Accept Cookies']"));
      //  wait.until(ExpectedConditions.visibilityOf(cookies));
       //Thread.sleep(3000);
     //   cookies.click();

        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        //Thread.sleep(4000);
        // Darg and drop
        // 1. WAY :
        //actions.dragAndDrop(source,target).perform();

        // 2. WAY :
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().build().perform();
    }
}
