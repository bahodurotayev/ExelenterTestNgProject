package com.exelenter.class04;

import org.testng.annotations.Test;

public class _01GroupDemo {
    @Test(dependsOnMethods = "test2")
    void test1(){
        System.out.println("test 1");
    }
    @Test(groups = "smoke")
    void test2(){
        System.out.println("test 2");
    }
    @Test(groups = "regression")
    void test3(){
        System.out.println("test 3");
    }
    @Test(groups = {"smoke", "regression"})
    void test4(){
        System.out.println("test 4");
    }
    @Test
    void test5(){
        System.out.println("test 5");
    }
    @Test
    void test6(){
        System.out.println("test 6");
    }
}
