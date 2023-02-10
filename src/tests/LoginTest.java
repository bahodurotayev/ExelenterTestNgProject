package tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;
import static utils.BaseClass.*;
import static utils.PageInitializer.*;

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
        loginPage.login_To_Website("user", "password");
        Assert.assertEquals(dashboardPage.welcome.getText(), "Welcome Admin","Not able to log in");
    }

    @Test
    void validUserInvalidPassword(){

        loginPage.login_To_Website("user", "123");
        Assert.assertEquals(loginPage.invalidCredential.getText(), "Invalid credentials", "Password should not match");
    }

    @Test
    void validUserEmptyPassword(){
        loginPage.login_To_Website("user", " ");
        Assert.assertEquals(loginPage.emptyPassword.getText(), "Password cannot be empty", "Password should be empty");
    }
}
