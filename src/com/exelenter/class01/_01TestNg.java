package com.exelenter.class01;

import org.testng.annotations.*;

public class _01TestNg {
    @Test
    public static void sayHello(){
        System.out.println("Hello");
    }
    @Test
    public static void sayBye(){
        System.out.println("Bye");
    }

    @BeforeTest
    public static void beforeTest(){
        System.out.println("Before Test");
    }

    @AfterTest
    public static void afterTest(){
        System.out.println("After Test");
    }

    @BeforeMethod
    public static void beforeMethod(){
        System.out.println("Before Method");
    }
    @AfterMethod
    public static void afterMethod(){
        System.out.println("After Method");
    }

}
