package tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

import static utils.BaseClass.*;
public class LoginTest {
    @BeforeMethod
    void openBrowser(){
        setUp();
    }
    @AfterMethod
    void quiteBrowser(){
        tearDown();
    }

    @Test
    void validAdminLogin(){
        LoginPage loginPage = new LoginPage();
        send_Text(loginPage.username, ConfigReader.getProperties("user"));
        send_Text(loginPage.password, ConfigReader.getProperties("password"));
        click_clickAbility(loginPage.loginBtn);
        DashboardPage dashboardPage = new DashboardPage();
        Assert.assertEquals(dashboardPage.welcome.getText(), "Welcome Admin","Not able to log in");
    }

    @Test
    void validUserInvalidPassword(){
        LoginPage loginPage = new LoginPage();
        send_Text(loginPage.username, ConfigReader.getProperties("user"));
        send_Text(loginPage.password, "asda");
        click_clickAbility(loginPage.loginBtn);

        Assert.assertEquals(loginPage.invalidCredential.getText(), "Invalid credentials", "Password should not match");
    }

    @Test
    void validUserEmptyPassword(){
        LoginPage loginPage = new LoginPage();
        send_Text(loginPage.username, ConfigReader.getProperties("user"));
        send_Text(loginPage.password, "");
        click_clickAbility(loginPage.loginBtn);

        Assert.assertEquals(loginPage.emptyPassword.getText(), "Password cannot be empty", "Password should be empty");
    }
}
