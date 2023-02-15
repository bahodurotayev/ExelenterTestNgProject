package com.exelenter.class04;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.ConfigReader;

import java.util.ArrayList;

import static utils.BaseClass.*;
import static utils.PageInitializer.*;

public class _06HW extends BaseClass {
    @Test(dataProvider ="addEmployee")
    void addEmployees(String name, String lastName, String randomPassword){
        //String passCode = randomStrongPassWord();
        loginPage.login_To_Website("user", "password");
        pimPage.goToAddEmployee();

        send_Text(addEmployeePage.firstName, name);
        send_Text(addEmployeePage.lastName, lastName);
        send_Text(addEmployeePage.photoFile, ConfigReader.getProperties("picFilePath"));

        System.out.println(addEmployeePage.employeeId.getAttribute("value"));

        click_clickAbility(addEmployeePage.chkLogin);

        send_Text(addEmployeePage.userName, name.substring(0,3) + lastName.substring(0, 3));

        send_Text(addEmployeePage.userPassword, randomPassword);
        send_Text(addEmployeePage.confirmPassword, randomPassword);

        addEmployeePage.confirmPasswords();
        click_clickAbility(addEmployeePage.btnSave);
        waitSecond(2);

        Assert.assertEquals(personalDetailedPage.personalEmployeeName.getAttribute("value"), name, "Employee with " + name + " did not add");
        screenshot(personalDetailedPage.personalDetailsForm, name);

        pimPage.goToEmployeeList();
        selectValue(employeeListPage.searchEmployeeList, name);
        click_clickAbility(employeeListPage.searchBtn);
    }

    @DataProvider(name = "addEmployee")
    Object[][] data(){
        Object[][] userData = {
                {"Johnny","Rip", randomStrongPassWord()},
                /*{"Beth","Dutton", randomStrongPassWord()},
                {"Carl","Roe", randomStrongPassWord()},
                {"Ali","Vali", randomStrongPassWord()},
                {"Taylor","Donn", randomStrongPassWord()},*/
        };
        return userData;
    }

}

/*
  Task: HW: Add Employees using Data Provider Annotation
         1.  Open the Chrome browser
         2.  Go to https://exelentersdet.com/
         3.  Login into the application
         4.  Navigate to Add Employee Page
         5.  Add 5 different Employees and create login credentials by providing:
                 - First Name
                 - Last Name
                 - Username
                 - Password
         6.  Verify Employee has been added successfully and take screenshots (you
              must have 5 different screenshots)
         7.  Close the browser
              BONUS: Specify a group name for this test case, and execute from the
              XML file.
 */