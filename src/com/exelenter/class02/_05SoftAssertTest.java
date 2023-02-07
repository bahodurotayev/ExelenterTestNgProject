package com.exelenter.class02;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

import static utils.BaseClass.*;


public class _05SoftAssertTest {
    @BeforeTest
    void openBrowser(){
        setUp();
    }
    @AfterTest
    void closeBrowser(){
        tearDown();
    }


    @Test
    void softAssertDemo(){
        LoginPage loginPage = new LoginPage();

        boolean logoDisplayed = loginPage.homepageLogo.isDisplayed();
        logoDisplayed = false;

        //Assert.assertTrue(logoDisplayed, "Login logo is not displayed");  //validating logo //<-- hard assert

        //soft assert (if assert fails reamining test steps will continue)
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(logoDisplayed, "Logo is not displayed");

        // Second: Login to the website
        send_Text(loginPage.username, ConfigReader.getProperties("user"));
        send_Text(loginPage.password, ConfigReader.getProperties("password"));
        click_clickAbility(loginPage.loginBtn);
        DashboardPage dashboard = new DashboardPage();
        Assert.assertEquals(dashboard.welcome.getText(), "Welcome Admin", "'Welcome Admin' text is incorrect"); // Validating login
        System.out.println("Using Hard Assert if previous test assertion fails, this line will not print.");
    }
}
