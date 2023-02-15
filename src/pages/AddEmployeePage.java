package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.ConfigReader;

import static utils.BaseClass.*;
import static utils.CommonMethods.*;

public class AddEmployeePage {
    public AddEmployeePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "photofile")
    public WebElement photoFile;

    @FindBy(id = "btnSave")
    public WebElement btnSave;

    @FindBy(id = "employeeId")
    public WebElement employeeId;

    @FindBy(id = "chkLogin")
    public WebElement chkLogin;

    @FindBy(id = "user_name")
    public WebElement userName;

    @FindBy(id = "user_password")
    public WebElement userPassword;

    @FindBy(id = "re_password")
    public WebElement confirmPassword;


    public void add_Employee(String empFirstname, String empLastname, String filePath) {
        send_Text(firstName, empFirstname);
        send_Text(lastName, empLastname);
        send_Text(photoFile, ConfigReader.getProperties("filePath"));
        click_clickAbility(btnSave);
    }
    public void confirmPasswords(){
        Assert.assertEquals(userPassword.getText(), confirmPassword.getText(), "Password doesnt match");
    }
}