package com.exelenter.class02;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.BaseClass;
import utils.ConfigReader;

public class _02AssertDemo extends BaseClass {
    @BeforeTest
    void openBrowser(){
        setUp();
    }

    @AfterTest
    void quitBrowser(){
        tearDown();
    }

    @Test(priority = 1)
    void positiveLoginTest(){
        DashboardPage dashboardPage = new DashboardPage();
        LoginPage loginPage = new LoginPage();

        String expectedValue = "Welcome Admin";

        send_Text(loginPage.username, ConfigReader.getProperties("user"));
        send_Text(loginPage.password, ConfigReader.getProperties("password"));
        click_clickAbility(loginPage.loginBtn);

        Assert.assertEquals(dashboardPage.welcome.getText(), expectedValue,"Successfully Logged in");
    }

    @Test
    void negativeLoginTest(){

        String expectedValue = "Password cannot be empty";

        LoginPage loginPage = new LoginPage();
        send_Text(loginPage.username, ConfigReader.getProperties("user"));
        send_Text(loginPage.password, "");
        click_clickAbility(loginPage.loginBtn);

        Assert.assertEquals(loginPage.emptyPassword.getText(), expectedValue, "Password cannot be empty");
    }
}
