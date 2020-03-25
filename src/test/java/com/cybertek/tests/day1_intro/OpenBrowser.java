package com.cybertek.tests.day1_intro;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {
    public static void main(String[] args) {

        // hey webDriverMAnager, can u prepare chore for automation
        WebDriverManager.chromedriver().setup();
        // it is open empty chrome browser
        WebDriver driver = new ChromeDriver();
        // it is open what ever u type
        driver.get("https://cybertekschool.com");





    }

}
