package com.exelenter.class02;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

import static utils.BaseClass.*;



public class _01LoginValidationTest {

    LoginPage loginPage = new LoginPage();

    @BeforeTest
    public void openBrowser(){
        setUp();
    }
    @AfterTest
    public void closeBrowser(){
        tearDown();
    }

    @Test
    public void titleValidation(){
        String expectedValue = "Exelenter Project";
        String  actualValue = driver.getTitle();

        if (actualValue.equals(expectedValue)){
            System.out.println("Title does match");
        }
        else {
            System.out.println("Title does not match");
        }
    }

    @Test
    void logoValidation(){
        LoginPage loginPage = new LoginPage();
        if(loginPage.homepageLogo.isDisplayed()){
            System.out.println("waaalaaa  Logo is displayed");
        }else {
            System.out.println("Logo is not displayed");
        }
    }
    @Test
    void validLoginTest(){

        String expectedValue = "Welcome Admin";

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        send_Text(loginPage.username, ConfigReader.getProperties("user"));
        send_Text(loginPage.password, ConfigReader.getProperties("password"));
        click_clickAbility(loginPage.loginBtn);

        if(dashboardPage.welcome.getText().equals(expectedValue)){
            System.out.println("Successfully logged in");
        }else {
            System.out.println("You not logged in");
        }
    }
}
