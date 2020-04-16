package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AttributeTest {
    WebDriver driver = WebDriverFactory.getDriver("chrome");
    @Test
    public void test1(){
    driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement radioButton = driver.findElement(By.id("blue"));

        //get the value of type attribute
        System.out.println(radioButton.getAttribute("type"));

        //get the value of name attribute
        System.out.println(radioButton.getAttribute("name"));

        //get the value of checked
        // if u write checked attribute , it will return true or false
        System.out.println(radioButton.getAttribute("checked"));

        // trying to get attribute does not exist
        System.out.println(radioButton.getAttribute("href"));
        // it will return null, because href/link is not exist in element

        //taking just currents elements full html code
        System.out.println(radioButton.getAttribute("outerHTML"));


        System.out.println("**************isDisplayed()*****************");
        //bazen kod html de olur ama ekranda olmaya bilir buton section .. hiddin olabilir

        radioButton.isDisplayed();



    }

    @AfterMethod
    public void after(){
        driver.quit();
    }
}
