package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyUrlChanged {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser
         * go to http://practice.cybertekschool.com/forgot_password Links to an external site.
         * enter email
         * verify that url did  change to http://practice.cybertekschool.com/email_sent
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

       // String currentUrl = driver.getCurrentUrl();

        WebElement enterEmail = driver.findElement(By.name("email"));
        Faker mail = new Faker();
        String emailRndm= mail.internet().emailAddress();

        // enter any email with sendKeys for keyboard action to the WebElement
        enterEmail.sendKeys(emailRndm ); //+ Keys.ENTER
        Thread.sleep(3000);

        // click retrieve button
        WebElement retrievePasswordBtn = driver.findElement(By.id("form_submit"));  // we give the position of button for selenium
        retrievePasswordBtn.click();

        // verify tahat url chang to ;
        String expectedUrl = "http://practice.cybertekschool.com/email_sent";

        // get current url
        String currentUrl = driver.getCurrentUrl();

        if(currentUrl.equals(expectedUrl)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("currentUrl: " + currentUrl);
            System.out.println("expectedUrl: "+ expectedUrl);
        }

        Thread.sleep(3000);
        driver.close();

    }
}
