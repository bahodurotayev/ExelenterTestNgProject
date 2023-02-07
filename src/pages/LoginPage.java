package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;

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
}
