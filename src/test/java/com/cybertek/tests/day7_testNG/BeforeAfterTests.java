package com.cybertek.tests.day7_testNG;
import org.testng.annotations.*;

public class BeforeAfterTests {
    @BeforeMethod
    public  void setUp(){
        // WebDriver Part * this run FIRST for each of Test Anotation!!!!!
        System.out.println("BEFORE METHOD HERE");
        System.out.println("WebDriver Part");
    }
    @AfterMethod
    public void  tearDown(){
        // this run LASTTTT for each of Test Anotation!!!!!
        //close browser,Quit
        System.out.println("AFTER METHOD HERE");
        System.out.println("Driver Quit");
    }

    @BeforeClass
    public void setUpClass(){
        System.out.println("--- BEFORE CLASS ---");
        //classın tüm testlerin başında 1 kere çalısır
    }

    @AfterClass
    public void afterClass(){
        System.out.println("--- BEFORE CLASS---");
        //tüm testler bitince calısır 1 kere
    }



    @Test
    public  void test1(){
        System.out.println("This is my test 1");
    }

    @Ignore // this ignore test2
    @Test
    public void test2(){
        System.out.println("This is my test 2");
    }

    @Test
    public void test3(){
        System.out.println("This is my test 2");
    }
}
