package com.cybertek.tests.day7_testNG;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals("title","title","Verify message");

        System.out.println("Second Assertion");
        Assert.assertEquals(1,1);

        Assert.assertTrue(2>1);
    }

    @Test
    public void test2(){
        System.out.println("First Assertion");
        Assert.assertEquals("title","title");
        System.out.println("Second Assertion");
        Assert.assertEquals(1,2,"verify boolean ");
    }


    @Test
    public void test3(){
        String expectedTitle = "Cyb";
        String actualTitle = "Cybertek";

        Assert.assertTrue(actualTitle.startsWith(expectedTitle));
    }

    @Test
    public void test4(){
        // verify that email contains @
        String email= "mike@smith.com";

        Assert.assertTrue(email.contains("@"));
    }

    @Test
    public void test5(){
        // verify smthing is false
        Assert.assertFalse(0>1, "verify 0 not big then 1 ");
    }

    @Test
    public void test6(){
        // verify not equal
        Assert.assertNotEquals("title", "TITLE");
}
}
