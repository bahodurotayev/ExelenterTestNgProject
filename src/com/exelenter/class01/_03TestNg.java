package com.exelenter.class01;

import org.testng.annotations.*;

public class _03TestNg {
    @Test(enabled = false) // If you want to ignore a test, use attribute 'enabled=false' (do not run this test).
    void test01(){
        System.out.println("Test One");
    }
    @Test
    void test02(){
        System.out.println("Test Two");
    }
    @Test
    void test03(){
        System.out.println("Test Three");
    }
    @BeforeTest
    void beforeTest(){
        System.out.println("Before Test");
    }
    @AfterTest
    void afterTest(){
        System.out.println("After Test");
    }
    @BeforeMethod
    void beforeMethod(){
        System.out.println("Before Method");
    }
    @AfterMethod
    void afterMethod(){
        System.out.println("After Method");
    }

}
