package com.exelenter.class03;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static utils.BaseClass.*;


public class _01SoftAssert {
    @Test
    void testCase(){
        /*System.out.println("Before Asset");
        Assert.assertTrue(false);
        System.out.println("After Assert");*/

        System.out.println("Before soft Assert");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(true);
        System.out.println("After soft assert");
        softAssert.assertAll();
        System.out.println("After softAsser.All");
    }
}
