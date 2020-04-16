package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    WebDriver driver = WebDriverFactory.getDriver("chrome");

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //findElements multrilbe elements we can get
        //save ours Webelements inside list
        List<WebElement> buttons =  driver.findElements(By.xpath("//button"));
        System.out.println("buttons.size() = " + buttons.size());

        Assert.assertEquals(buttons.size(), 6);

       // just type iter push enter
        for (WebElement oneOfThem : buttons){
            //oneOfThem.click();
            System.out.println(oneOfThem.getText());
        }
    }


    @AfterMethod
    public void after(){
        driver.quit();
    }
}
