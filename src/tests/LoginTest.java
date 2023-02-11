package tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.ConfigReader;
import static utils.BaseClass.*;
import static utils.PageInitializer.*;

public class LoginTest extends BaseClass {


    @Test
    void validAdminLogin(){
        loginPage.login_To_Website("user", "password");
        Assert.assertEquals(dashboardPage.welcome.getText(), "Welcome Admin","Not able to log in");
    }

    @Test
    void validUserInvalidPassword(){

        send_Text(loginPage.username, ConfigReader.getProperties("user"));
        send_Text(loginPage.password, "asda");
        click_clickAbility(loginPage.loginBtn);
        Assert.assertEquals(loginPage.invalidCredential.getText(), "Invalid credentials", "Password should not match");
    }

    @Test
    void validUserEmptyPassword(){
        send_Text(loginPage.username, ConfigReader.getProperties("user"));
        send_Text(loginPage.password, "");
        click_clickAbility(loginPage.loginBtn);
        Assert.assertEquals(loginPage.emptyPassword.getText(), "Password cannot be empty", "Password should be empty");
    }
}
