package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
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
    public void switchWindowsTest(){
        driver.get("http://practice.cybertekschool.com/windows");

        String actuallTitle = driver.getTitle();
        System.out.println("Title before new window : " + actuallTitle );
        // handle = unique identifier
        String currentWindowHandle = driver.getWindowHandle();
        System.out.println("current Window Handle = " + currentWindowHandle);
        driver.findElement(By.linkText("Click Here")).click();

        // we will switch to new window
        String newWindowHandle=null;
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(currentWindowHandle)){
                newWindowHandle=handle;
            }

        }
        // it automaticly remove deplucate value!! just keep unique value,it is not working index number

        System.out.println("newWindowHandle = " + newWindowHandle);
        driver.switchTo().window(newWindowHandle);
        String expectedTitle= driver.getTitle();
        System.out.println("Title after new window : " + expectedTitle );

    }

    @Test
    public void moreThan2Window() {
        driver.get("http://practice.cybertekschool.com/windows");
        String currentWindowHandle = driver.getWindowHandle();
        System.out.println("current Window Handle = " + currentWindowHandle);
        String actuallTitle = driver.getTitle();
        System.out.println("Title before new window : " + actuallTitle );
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            // one by one change it !!
            driver.switchTo().window(handle);
            // whenever your title equals to expecterd title Stop!
            if (driver.getTitle().equals("New Window")){
                break;
            }
        }
        System.out.println("new handle: "  + driver.getWindowHandle());
        String expectedTitle= driver.getTitle();
        System.out.println("Title after new window : " + expectedTitle );

    }
}
