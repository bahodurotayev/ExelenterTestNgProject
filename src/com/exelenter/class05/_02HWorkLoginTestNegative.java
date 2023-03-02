package com.exelenter.class05;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.ExcelUtility;

import static utils.PageInitializer.loginPage;

public class _02HWorkLoginTestNegative extends BaseClass {
    @Test(dataProvider = "loginTest")
    void loginTest(String username, String password, String message){
        loginPage.login_To_Website2(username, password);
        Assert.assertEquals(loginPage.errorMessage.getText(), message, "Error message is incorrect");
    }

    @DataProvider(name = "loginTest")
    public Object[][] getDataFromExcel2(){
        String absolutePath = ExcelUtility.projectPath + "/testData/bo.xlsx";
        return ExcelUtility.readFromExcel(absolutePath, "NegativeLoginTests");
    }
}
