package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class textLinkAndPartialLinkText {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        WebElement link1 = driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
        link1.click();
        Thread.sleep(2000);
        driver.navigate().back();
        // just pick SOME PART OF UNIQUE link park then call it locate it with it

        WebElement link2 = driver.findElement(By.partialLinkText("Example 4"));
        link2.click();

        driver.quit();
    }
}
