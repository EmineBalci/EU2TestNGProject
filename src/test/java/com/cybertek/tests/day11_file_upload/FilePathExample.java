package com.cybertek.tests.day11_file_upload;

import org.testng.annotations.Test;

public class FilePathExample {

    @Test
    public void test(){

        //getting proect locatıon/path dynamicly

//Users/jamaldemir/Desktop/EU2TestNGProject/src/test/resources/testfile.txt

        //getting project location/path dynamicly
        String projectPath = System.getProperty("user.dir");
        String relativePath = "src/test/resources/testfile.txt";

        String filePath = projectPath+"/"+relativePath;
        System.out.println("filePath = " + filePath);
    }
}
