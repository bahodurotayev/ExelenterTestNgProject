package com.exelenter.class04;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.ConfigReader;
import utils.ExcelUtility;

import static pages.EmployeeListPage.deleteEmployeeFromList;
import static utils.PageInitializer.*;

public class _06HW2 extends BaseClass {
    @Test(dataProvider ="readFromExcel", groups = "smoke")
    void addEmployees(String name, String lastName,String username, String randomPassword){

        loginPage.login_To_Website("user", "password");

        pimPage.goToAddEmployee();

        send_Text(addEmployeePage.firstName, name);
        System.out.println("First name : " + name);
        send_Text(addEmployeePage.lastName, lastName);
        System.out.println("Last name  : " + lastName);
        send_Text(addEmployeePage.photoFile, ConfigReader.getProperties("picFilePath"));

        String employeeIdAttribute = addEmployeePage.employeeId.getAttribute("value");

        click_clickAbility(addEmployeePage.chkLogin);

        send_Text(addEmployeePage.userName, username);
        System.out.println("Username   : " + username);
        System.out.println("User Id    : " + addEmployeePage.employeeId.getAttribute("value"));

        send_Text(addEmployeePage.userPassword, randomPassword);
        send_Text(addEmployeePage.confirmPassword, randomPassword);
        System.out.println("Password   : " + randomPassword);

        addEmployeePage.confirmPasswords();

        click_clickAbility(addEmployeePage.btnSave);
        waitSecond(2);

        /*Assert.assertEquals(personalDetailedPage.personalEmployeeName.getAttribute("value"), name, "Employee with " + name + " did not add");
        screenshotFull(name);
        */
        try {
            boolean headerDisplayed = personalDetailedPage.personalDetailsForm.isDisplayed();
            if(headerDisplayed){
                Assert.assertEquals(personalDetailedPage.personalEmployeeName.getAttribute("value"), name, "Employee with " + name + " did not add");
                System.out.println("User successfully added");
                screenshotFull(name);
            }
        }catch (Exception exception){
            //exception.printStackTrace();
            System.out.println("Employee is not added " + username +" or " + employeeIdAttribute + " is already exist");
            Assert.fail();
            //2way
            //throw new RuntimeException("Employee is not added " + username +" or " + employeeIdAttribute + " is already exist");
        }

    }
    @Test(dependsOnMethods = "addEmployees", dataProvider = "readFromExcel")
    void deleteUsers(String name, String lastName,String username, String password){
        loginPage.login_To_Website("user", "password");
        deleteEmployeeFromList(name, lastName);
    }

    @DataProvider(name = "readFromExcel")
    public Object[][] getDataFromExcel(){
        String absolutePath = ExcelUtility.projectPath + "/testData/bo.xlsx";
        return ExcelUtility.readFromExcel(absolutePath, "Employee");
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