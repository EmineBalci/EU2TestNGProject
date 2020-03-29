package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import com.sun.media.sound.RIFFInvalidDataException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {
    public static void main(String[] args) throws InterruptedException {
     /*   open browser
        go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
        enter any email
        verify that email is displayed in the input box
        click on Retrieve password
        verify that confirmation message says 'Your e-mail's been sent!' */ // this EXPECTED MESSAGE

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        Faker faker = new Faker();
        String expectedEmail = faker.internet().emailAddress();

        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys(expectedEmail);
        Thread.sleep(3000);
        // GET TEXT From WebElements: There are 2 WAY;
        // 1. GET.TEXT()::     we can get from here
        //String text= emailInputBox.getText();  // but it is noot WORK for input box!

        // 2. getAttribute("value")::
        String actualEmail = emailInputBox.getAttribute("value");  // value is the attribute to call entered data, whatever user enter

        // verify test
        if (actualEmail.equals(expectedEmail)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        // click retrieve button
        WebElement retrievePasswordBtn = driver.findElement(By.id("form_submit"));  // we give the position of button for selenium
        // if u can not enter true position , true id name in find element,it will give ERROR!!! : Exception : NO SUCH ELEMENT
        retrievePasswordBtn.click();

        // locate message element;
        WebElement actualConfirmationMessage = driver.findElement(By.name("confirmation_message"));
       //print to message use GETTEXT!!
        String actualMessage = actualConfirmationMessage.getText();
        System.out.println(actualMessage);

        String expectedMessage = "Your e-mail's been sent!";

        //verify TEst
        if(expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expectedMessage: " + expectedMessage);
            System.out.println("actualMessage: "+ actualMessage);
        }

        driver.quit();







    }
}
