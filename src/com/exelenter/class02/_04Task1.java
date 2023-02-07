package com.exelenter.class02;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

import static utils.BaseClass.*;
public class _04Task1 {

    @BeforeTest
    public void openBrowser(){
        setUp();
    }
    @AfterTest
    public void closeBrowser(){
        tearDown();
    }

    @Test
    void validLoginTest(){
        DashboardPage dashboardPage = new DashboardPage();
        LoginPage loginPage = new LoginPage();

        String expectedValue = "Welcome Admin";

        send_Text(loginPage.username, ConfigReader.getProperties("user"));
        send_Text(loginPage.password, ConfigReader.getProperties("password"));
        click_clickAbility(loginPage.loginBtn);

        Assert.assertEquals(dashboardPage.welcome.getText(), expectedValue,"Unsuccessfully Logged in"); // message appears only if assertion fails
    }

    @Test(dependsOnMethods = "validLoginTest")
    void verifyLogoDashboard(){
        DashboardPage dashboardPage = new DashboardPage();
        Assert.assertTrue(dashboardPage.dashboardLogo.isDisplayed(), "Dashboard logo is not displayed");
    }
}
