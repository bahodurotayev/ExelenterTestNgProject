package com.exelenter.class04;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.ConfigReader;
import utils.PageInitializer;

import static utils.CommonMethods.*;
import static utils.PageInitializer.*;
import static utils.PageInitializer.*;


public class _05DataProvider extends BaseClass {

    @Test(dataProvider = "AddEmployee")
    void addEmployees(String firstName, String lastName){
        loginPage.login_To_Website("user", "password");
        pimPage.goToAddEmployee();
        send_Text(addEmployeePage.firstName, firstName);
        send_Text(addEmployeePage.lastName, lastName);

        String expectedValue = addEmployeePage.employeeId.getAttribute("value");

        click_clickAbility(addEmployeePage.btnSave);

        wait_visibility(personalDetailedPage.personalDetailsForm);
        String actualValue = personalDetailedPage.employeeId.getAttribute("value");

        Assert.assertEquals(actualValue, expectedValue,"Employee ID does not match");
    }

    @DataProvider(name = "AddEmployee")
    Object[][] dataProvider(){
        Object[][] data = {
                {"John", "Bravo"},
                {"Troy", "Esma"},
                {"Tommy", "Letch"},
        };
        return data;
    }

}
