package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static utils.BaseClass.*;
import static utils.PageInitializer.employeeListPage;
import static utils.PageInitializer.pimPage;

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

    @FindBy(css = "#resultTable td")
    public WebElement noEmployeeRecordFound;

    public void confirmNoRecordFound(){
        Assert.assertEquals(noEmployeeRecordFound.getText(), "No Records Found", "Same user was found");
    }

    public static void deleteEmployeeFromList(String name, String lastName) {
        pimPage.goToEmployeeList();
        waitSecond(1);
        send_Text(employeeListPage.employeeName, name + " " + lastName);
        click_clickAbility(employeeListPage.searchBtn);
        click_clickAbility(employeeListPage.selectAllId);
        click_clickAbility(employeeListPage.btnDelete);
        click_clickAbility(employeeListPage.confirmDeleteBtn);
        employeeListPage.confirmNoRecordFound();
    }
}
