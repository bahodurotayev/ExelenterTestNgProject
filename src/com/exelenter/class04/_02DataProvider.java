package com.exelenter.class04;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02DataProvider {
    //Data Driven Testing
    //Behavior Driven Testing

    @Test(dataProvider = "user")
    void printData(String firstName, String lastName, int age){
        System.out.println(firstName + lastName);

    }
    @DataProvider
    public Object[][] user(){
        Object[][] user = {
                {"John", "Wick", 39},
                {"Frey", "Troy", 24},
                {"Bred", "Soprano", 45}
        };
        return user;
    }
}
