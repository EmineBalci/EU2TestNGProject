package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class mycase1 {
    WebDriver driver;
    @BeforeMethod
    public void before (){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://qa1.vytrack.com/user/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void after() throws InterruptedException {
        Thread.sleep(4000);
        //    driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
//    "1.Verify that truck driver should be able to see all Vehicle information once navigate to Vehicle page.
//     2.Verify that when user click on any car on the grid , system should display general information about the car
//     3.Verify that truck driver can add Event and it should display under Activity tab and General information page as well .
//     4.Verify that Truck driver can reset the Grid by click on Grid setting"

        driver.findElement(By.id("prependedInput")).sendKeys("user4");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(2000);


        WebElement fleetgrid = driver.findElement(By.cssSelector("[class='title title-level-1']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(fleetgrid).perform();


        WebElement vehicleButton = driver.findElement(By.xpath("//span[text()='Vehicles']"));
        actions.moveToElement(vehicleButton).click().perform();
        Thread.sleep(2000);

       WebElement compactCar = driver.findElement(By.xpath("//td[text()='91ME7118']"));
        actions.moveToElement(compactCar).doubleClick().perform();

       // driver.findElement(By.xpath("//td[text()='91ME7118']")).click();

        Thread.sleep(5000);

    }
}
