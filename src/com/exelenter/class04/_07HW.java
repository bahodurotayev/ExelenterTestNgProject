package com.exelenter.class04;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.ConfigReader;

import static pages.EmployeeListPage.deleteEmployeeFromList;
import static utils.PageInitializer.*;

public class _07HW extends BaseClass {
    @Test(dataProvider = "addEmployee")
    void deleteUsers(String name, String lastName, String password){
        loginPage.login_To_Website("user", "password");
        deleteEmployeeFromList(name, lastName);
    }

    @DataProvider(name = "addEmployee")
    Object[][] data(){
        Object[][] userData = {
                {"Johnny","Rip", randomStrongPassWord()},
                {"Beth","Dutton", randomStrongPassWord()},
                {"Carl","Roe", randomStrongPassWord()},
                {"Ali","Vali", randomStrongPassWord()},
                {"Taylor","Donn", randomStrongPassWord()},
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