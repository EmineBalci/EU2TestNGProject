package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import jdk.internal.org.objectweb.asm.commons.JSRInlinerAdapter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframes {
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
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");
        //driver.findElement(By.id("tinymce")).sendKeys("Mike Smith"); IT IS NOT WORK!!

        // HTML kodunda iframe tagının altında yeni bir HTML tab i var.
        // Page in page..

        // how to switch frames
        // 1..switch by using name or id attribute of iframe
        driver.switchTo().frame("mce_0_ifr");

        //clear text before sendkeys
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith");

        // goes back to first frame(main html)
        // goes back to first frame useful when we have switched multiple frames
        driver.switchTo().defaultContent();
        Thread.sleep(1000);

        // 2..  Using INDEX
        driver.switchTo().frame(0);

        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith with index");

        // 2.way to switch parent
        driver.switchTo().parentFrame();


        // 3.. using WebElement
        // locating with any valid locator
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframeElement);
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith with Web Element");

    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");
        // we have 6 html in this web site!!
        // FRAME SET örneği ,2 anda frame ve alt frame leri mevcut
        /* main HTML ..///Default
                frame-top ..child sibilings  /// parent
                  index- 0  left    ..sibilings - grand child   ///child
                  index- 1  middle  ..sibilings - grand child
                  index- 2 right   ..sibilings - grand child
                frame-bottom .. child sibilings
       */

        // switching to frame-top
        driver.switchTo().frame("frame-top");
        // top has 3 child lets go middle
        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.id("content")).getText());

        // switch to parent (frame top)
        driver.switchTo().parentFrame();

        // switch to right frame
        driver.switchTo().frame(2);

        //to switvh main html we can use default
        driver.switchTo().defaultContent();

        // switch to bottom
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.tagName("body")).getText());

    }
}
