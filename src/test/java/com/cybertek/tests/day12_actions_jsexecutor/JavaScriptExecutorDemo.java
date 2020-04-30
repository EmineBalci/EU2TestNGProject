package com.cybertek.tests.day12_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorDemo {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void clickWithJS() {
        driver.get("http://practice.cybertekschool.com/");
        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));

        // Clicking with Javascript executor
       // JavascriptExecutor jse = (JavascriptExecutor)driver;

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdownLink);

    }

    @Test
    public void type(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputbox = driver.findElement(By.cssSelector("#input-example>input"));
        // it is disable menu !!
      //  inputbox.sendKeys("Some Text");  // it will give ElementNotInteractableException

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String str = "Hello disable input";
        jse.executeScript("arguments[0].setAttribute('value', '" + str + "')", inputbox);

    }

    @Test
    public void scrollDownAndUp() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        Thread.sleep(2000);

        for (int i=0; i<5; i++) {
            Thread.sleep(500);
            jse.executeScript("window.scrollBy(0,2000)");
        }

        for (int i=0; i<5; i++) {
            Thread.sleep(500);
            jse.executeScript("window.scrollBy(0,-250)");
        }

    }
}
