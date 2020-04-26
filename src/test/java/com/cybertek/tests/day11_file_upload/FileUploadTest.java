package com.cybertek.tests.day11_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        driver = WebDriverFactory.getDriver("chrome");
    }


    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/upload");

        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        // to copy path use shift+
        chooseFile.sendKeys("C:\\Users\\ASUS\\Desktop\\file.txt");

        driver.findElement(By.id("file-submit")).click();

        String expectedName = "file.txt";
        String actualName = driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actualName,expectedName);

    }

    @Test
    public void test2() {
        driver.get("http://practice.cybertekschool.com/upload");

        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        // to copy path use shift+
        //chooseFile.sendKeys("C:\\Users\\ASUS\\Desktop\\file.txt");
        String projectPath = System.getProperty("user.dir");
        String relativePath = "src/test/resources/testfile.txt";

        String filePath = projectPath+"/"+relativePath;

        chooseFile.sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();

        String expectedName = "testfile.txt";
        String actualName = driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actualName,expectedName);

    }
}
