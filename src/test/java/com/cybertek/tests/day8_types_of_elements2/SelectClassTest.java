package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectClassTest {
    WebDriver driver = WebDriverFactory.getDriver("chrome");

    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/dropdown");

        // 1.locate your dropdown just like any other webelement
        WebElement dropdownElement = driver.findElement(By.id("state"));

        // 2. create Select object by passing that elements as aconstructor
        // if u have select keyword in HTML , use it, birsürü secenek va hangisini sececeksin nasıl sececeksiz bak asagı;
        Select stateDropdown = new Select(dropdownElement); //one parameter constructor

        // 3. getOptions --> returns all the available options from the dropdown list
        List<WebElement> options = stateDropdown.getOptions();

        // 4. print size of the options
        System.out.println("options.size() = " + options.size());

        // 5. print options one by one
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dropdown");

        // 1.locate your dropdown just like any other webelement
        WebElement dropdownElement = driver.findElement(By.id("state"));

        // 2. create Select object by passing that elements as aconstructor
        // if u have select keyword in HTML , use it, birsürü secenek va hangisini sececeksin nasıl sececeksiz bak asagı;
        Select stateDropdown = new Select(dropdownElement); //one parameter constructor

        // Verify that first selection is "Select a State"

        String expectedOption = "Select a State";
        String actualOption = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOption,expectedOption,"Verify first selections");

        // How to select options from dropdown?
        // 1.way= select using visible text
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Texas");
        expectedOption = "Texas";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actualOption);
        Thread.sleep(2000);


        // 2. Way: Select USING Index
        stateDropdown.selectByIndex(51); // toplamda 52 tane var sonuncu 51. index
        expectedOption = "Wyoming";
        Thread.sleep(2000);
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actualOption);

        // 3. Way :Select by value;
        stateDropdown.selectByValue("DC");
        expectedOption = "District Of Columbia";
        Thread.sleep(2000);
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actualOption);




    }

    @AfterMethod
    public void after(){
        driver.quit();
    }
}
