package com.cybertek.tests.day7_types_of_elements;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {
    WebDriver driver = WebDriverFactory.getDriver("chrome");
    @Test
    public void radioBtnTest1() {
        //WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenRadioButton = driver.findElement(By.id("green")); // it is disabled web element

        // how to check WebElement is enable or not ??  isEnable()!!!!
        System.out.println("IS element enable: " + greenRadioButton.isEnabled());

        // verify
        Assert.assertFalse(greenRadioButton.isEnabled(), "Verify Green button is not enable");

        //driver.quit();
    }


    @Test
    public void radioBtnTest2() {

        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
       inputBox.sendKeys("Mike");  // this is disable input box!!!

        driver.quit();
    }
}
