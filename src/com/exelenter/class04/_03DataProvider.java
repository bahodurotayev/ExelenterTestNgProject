package com.exelenter.class04;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseClass;

import static utils.PageInitializer.*;

public class _03DataProvider extends BaseClass {

    @Test
    void loginTest(){
        send_Text(loginPage.username, "Admin");
        send_Text(loginPage.password, "password");
        click_clickAbility(loginPage.loginBtn);
        boolean welcomeIsDisplayed = dashboardPage.welcome.isDisplayed();
        Assert.assertTrue(welcomeIsDisplayed, "Welcome message is not displayed");
    }
    @Test
    void loginTest2(){
        send_Text(loginPage.username, "asd");
        send_Text(loginPage.password, "passasdsaword");
        click_clickAbility(loginPage.loginBtn);
        boolean welcomeIsDisplayed = dashboardPage.welcome.isDisplayed();
        Assert.assertTrue(welcomeIsDisplayed, "Welcome message is not displayed");
    }
    @Test
    void loginTest3(){
        send_Text(loginPage.username, "gfhghgj");
        send_Text(loginPage.password, "");
        click_clickAbility(loginPage.loginBtn);
        boolean welcomeIsDisplayed = dashboardPage.welcome.isDisplayed();
        Assert.assertTrue(welcomeIsDisplayed, "Welcome message is not displayed");
    }


}
