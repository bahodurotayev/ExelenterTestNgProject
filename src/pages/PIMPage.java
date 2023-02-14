package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.BaseClass.*;
import static utils.CommonMethods.click_clickAbility;

public class PIMPage {
    public PIMPage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement  pimSection;

    @FindBy(id = "menu_pim_addEmployee")
    public WebElement addEmployee;

    @FindBy(id = "menu_pim_viewEmployeeList")
    public WebElement employeeList;


    public void goToAddEmployee(){
        click_clickAbility(pimSection);
        click_clickAbility(addEmployee);
    }
}
