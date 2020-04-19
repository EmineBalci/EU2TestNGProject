package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {

    WebDriver driver = WebDriverFactory.getDriver("chrome");
    @Test
    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dropdown");

        // 1.locate your dropdown just like any other webelement
        WebElement dropdownElement = driver.findElement(By.id("dropdownMenuLink"));

        dropdownElement.click();

        List<WebElement> dropdownOptions = driver.findElements(By.cssSelector(".dropdown-item"));

        // iter shortcut
        for (WebElement dropdownOption : dropdownOptions) {
            System.out.println(dropdownOption.getText());
        }
        // Click Yahoo
        dropdownOptions.get(2).click();

        driver.quit();





    }
}
