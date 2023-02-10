package utils;

import pages.*;

public class PageInitializer extends BaseClass{

    public static AddEmployeePage addEmployeePage;
    public static DashboardPage dashboardPage;
    public static EmployeeListPage employeeListPage;
    public static LoginPage loginPage ;
    public static PIMPage pimPage;


    public static void initialize(){
        addEmployeePage = new AddEmployeePage();
        dashboardPage = new DashboardPage();
        employeeListPage = new EmployeeListPage();
        loginPage = new LoginPage();
        pimPage = new PIMPage();
    }

}
