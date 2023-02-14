package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    public void add_Employee(String empFirstname, String empLastname, String filePath) {
        send_Text(firstName, ConfigReader.getProperties(empFirstname));
        send_Text(lastName, ConfigReader.getProperties(empLastname));
        send_Text(photoFile, ConfigReader.getProperties(filePath));
        click_clickAbility(btnSave);
    }
}