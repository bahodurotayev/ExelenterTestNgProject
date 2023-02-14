package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;
import utils.ConfigReader;

import static utils.CommonMethods.click_clickAbility;
import static utils.CommonMethods.send_Text;


public class LoginPage extends BaseClass {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "txtUsername")
    public WebElement username;

    @FindBy(name = "txtPassword")
    public WebElement password;

    @FindBy(xpath = "//input[@id='btnLogin']")
    public WebElement loginBtn;

    @FindBy(css = "#divLogo img")
    public WebElement homepageLogo;

    @FindBy(id = "spanMessage")
    public WebElement invalidCredential;

    @FindBy(id = "spanMessage")
    public WebElement emptyPassword;

    public void login_To_Website(String user, String pswd) {
        send_Text(username, ConfigReader.getProperties(user));
        send_Text(password, ConfigReader.getProperties(pswd));
        click_clickAbility(loginBtn);
    }
}
