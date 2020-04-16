package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CheckboxDemo {
    WebDriver driver = WebDriverFactory.getDriver("chrome");

    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[2]"));

        // how to verify checkbox is selected or not ??
        // lets learn default
        System.out.println("checkbox1 = " + checkbox1.isSelected());
        System.out.println("checkbox2 = " + checkbox2.isSelected());

        // verify checkbox 1 is not selected , 2 is selected
        Assert.assertFalse(checkbox1.isSelected(),"Verify checkbox 1 is NOT selected");
        Assert.assertTrue(checkbox2.isSelected(), "Verify checkbox 2 is selected");

        // how to click checkbox??
        checkbox1.click();
        Assert.assertTrue(checkbox1.isSelected(),"Verify checkbox 1 is selected");
        // 2. box degismez , radio buttondan farkı bu!!!
        Assert.assertTrue(checkbox2.isSelected(), "Verify checkbox 2 is selected");



    }

    @AfterMethod
    public void after(){
        driver.quit();
    }
}
