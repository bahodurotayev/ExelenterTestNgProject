package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static utils.BaseClass.*;
public class PersonalDetailedPage {
    public PersonalDetailedPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "personal_txtEmployeeId")
    public WebElement employeeId;

    @FindBy(css = "#pdMainContainer h1")
    public WebElement personalDetailsForm;
}
