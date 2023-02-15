package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utils.BaseClass.*;

public class EmployeeListPage {
    public EmployeeListPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "empsearch_employee_name_empName")
    public WebElement employeeName;

    @FindBy(id = "empsearch_id")
    public WebElement employeeId;

    @FindBy(id = "searchBtn")
    public WebElement searchBtn;

    @FindBy(id = "ohrmList_chkSelectAll")
    public WebElement selectAllId;

    @FindBy(id = "btnDelete")
    public WebElement btnDelete;

    @FindBy(id = "dialogDeleteBtn")
    public WebElement confirmDeleteBtn;

    @FindBy(xpath = "//li[@class='ac_even ac_over']")
    public List<WebElement> searchEmployeeList;


}
