package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {
        // setting up my chrome browser for automation
        WebDriverManager.chromedriver().setup();
        // creating driver object for chrome
        WebDriver driver = new ChromeDriver();

        //navigate to Google
        driver.get("https://google.com");

        driver.navigate().to("https://facebook.com");

        // wait 3 seconds here in line 19 -- we call it "static Wait"3
        Thread.sleep(3000);


        // how to go back to google after we navigate to face
        // goes back to previous page

        driver.navigate().back();

        // goes forward goes back
        driver.navigate().forward();

        // reflesh current page
        driver.navigate().refresh();

    }




}
