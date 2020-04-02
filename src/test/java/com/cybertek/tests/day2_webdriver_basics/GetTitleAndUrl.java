package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://facebook.com");

        driver.navigate().to("http://practice.cybertekschool.com");

        // getting title with selenium // shotcut alt+enter
        String title = driver.getTitle();

        // soutv  oto print
        System.out.println("title = " + title);

        // get url
        String currentUrl = driver.getCurrentUrl();
        //print url soutv
        System.out.println("currentUrl = " + currentUrl);

        // get Source code  all html codes
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);

    }

}
