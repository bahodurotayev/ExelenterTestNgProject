package com.exelenter.class04;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.ConfigReader;

import static utils.PageInitializer.dashboardPage;
import static utils.PageInitializer.loginPage;

public class _04DataProvider extends BaseClass {

    @Test(dataProvider = "loginUsers")
    void loginTest(String username, String password){
        send_Text(loginPage.username, username);
        send_Text(loginPage.password, password);
        click_clickAbility(loginPage.loginBtn);
        boolean welcomeIsDisplayed = dashboardPage.welcome.isDisplayed();
        Assert.assertTrue(welcomeIsDisplayed, "Welcome message is not displayed");
    }

    @DataProvider(name = "loginUsers")
    Object[][] dataProvider(){
        Object[][] data = {
                {"Admin", "Exelent2022Sdet!"},
                {"johndoe", "k#G886@H"},
                {"EssUser", "Ess@2023"}
        };
        return data;
    }
}
