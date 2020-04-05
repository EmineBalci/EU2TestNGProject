package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class xpathTest {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://amazon.com");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("selenium");
        driver.findElement(By.xpath("//input[@value='Go']")).click();

        String text= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[1]")).getText();
        // find icin alternatf:  //span[contains(text(),'results for')];
        System.out.println("text = " + text);

        driver.quit();

    }
}
