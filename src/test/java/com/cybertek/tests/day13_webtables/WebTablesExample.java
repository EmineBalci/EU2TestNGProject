package com.cybertek.tests.day13_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/tables");

    }


    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    // hover
    @Test
    public void printTable() {
     WebElement table= driver.findElement(By.id("table1"));

     // it is not good way to test, if table huge
     System.out.println(table.getText());
     Assert.assertTrue(table.getText().contains("jsmth@gmail.com"));
    }

    @Test
    public void getAllHeadres() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        // table#table1 th
        System.out.println("headers.size() = " + headers.size());

        // iter
        for (WebElement header : headers) {
            System.out.println(header.getText());
        }
    }

    @Test
    public void printTableSize() {
        //How many columns we HAVE?
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        // table#table1 th
        System.out.println("headers.size() = " + headers.size());

        //How many rows we HAVE? with header
        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println(allRowsWithHeader.size());

        //How many rows we HAVE? without header ** this is common one !!
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println(allRowsWithoutHeader.size());

    }

    @Test
    public void getRow() {
        //How many rows we HAVE? without header ** this is common one !!
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println(allRows.size()); //WithoutHeader

        WebElement secondRow = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));


        WebElement row;
        for (int i = 1; i <= allRows.size() ; i++) {
            row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));
            System.out.println("row "+i+" = " + row.getText());
        }
    }

    @Test
    public void getAllCellInOneRow() {
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[3]/td"));
        System.out.println(allRows.size()); //WithoutHeader

        for (WebElement allRow : allRows) {
            System.out.println(allRow.getText());
        }
    }

    @Test
    public void getASingleCellByIndex(){
      WebElement singleCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[4]/td[5]"));
        System.out.println(singleCell.getText());
    }


    @Test
    public void PrintAllCellsByIndex(){
        int rowNumber= getNumOfRows();
        int colNumber = getNumOfColumns();
        System.out.println("colNumber = " + colNumber);
        System.out.println("rowNumber = " + rowNumber);

        // html de önce row var!!!
        WebElement cell;
        for (int i=1; i<=rowNumber; i++){
            for (int j=1; j<=colNumber; j++){
                cell= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]"));
                System.out.println("Cell ["+i+"] ["+j+"] = " + cell.getText());
            }
        }

    }

    @Test
    public void getCelInRelationToAnotherCellInSameRow(){
        String firstName= "John";
        String xpath = "//table[@id='table1']//td[.='"+firstName+"']/../td[3]"; // 3 is for email
    }

    private int getNumOfColumns() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return headers.size();
    }

    private int getNumOfRows() {
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return allRows.size();
    }


    // HOMEWORK : create a method that accepts row and col num and returns the cell as a web elemnt

    public WebElement findCell (int row, int coloums){
        WebElement cell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+row+"]/td["+coloums+"]"));
        return cell;
    }


}