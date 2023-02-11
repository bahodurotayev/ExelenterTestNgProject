package tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseClass;

import static utils.PageInitializer.*;

public class AddEmployeeTest extends BaseClass {
    @Test
    void addEmployeeTest(){
        loginPage.login_To_Website("user", "password");
        pimPage.goToAddEmployee();
        System.out.println("New employee ID is : " + addEmployeePage.employeeId.getAttribute("value"));
        addEmployeePage.add_Employee("firstname", "lastname", "picFilePath");
    }
}
