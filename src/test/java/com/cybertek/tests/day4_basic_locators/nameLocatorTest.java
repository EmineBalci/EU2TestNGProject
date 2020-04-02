package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        //to make chrome fullscreen
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInputBox = driver.findElement(By.name("full_name"));
        fullNameInputBox.sendKeys("Mike Smith");

        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("asd@asd.com");
        Thread.sleep(1000);

        WebElement singUpButton = driver.findElement(By.name("wooden_spoon"));
        singUpButton.click();
        // shortCUT: driver.findElement(By.name("wooden_spoon")).click();

        String expectedMessage= "Thank you for signing up. Click the button below to return to the home page.";

        Thread.sleep(2000);

        WebElement singupMessage = driver.findElement(By.name("signup_message"));

        String actualMessage = singupMessage.getText();
        // short CUT: String actualMessage = driver.findElement(By.name("signup_message")).getText();

        if (expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        driver.quit();

    }
}
