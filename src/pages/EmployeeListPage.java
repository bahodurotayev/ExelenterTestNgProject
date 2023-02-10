package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static utils.BaseClass.*;

public class EmployeeListPage {
    public EmployeeListPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "empsearch_employee_name_empName")
    public WebElement employeeName;

    @FindBy(id = "empsearch_id")
    public WebElement employeeId;

}
