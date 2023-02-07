package com.exelenter.class02;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

import static utils.BaseClass.*;


public class _03LoginValidationTest {

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
        Assert.assertEquals(driver.getTitle(), expectedValue, "Title does not match");
    }

    @Test(dependsOnMethods = "titleValidation")
    void logoValidation(){
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.homepageLogo.isDisplayed(), "Logo Homepage is not displayed");
    }
    @Test
    void validLoginTest(){

        String expectedValue = "Welcome Admin";

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        send_Text(loginPage.username, ConfigReader.getProperties("user"));
        send_Text(loginPage.password, ConfigReader.getProperties("password"));
        click_clickAbility(loginPage.loginBtn);

        Assert.assertEquals(dashboardPage.welcome.getText(), expectedValue, "You are not logged in");
    }
}
