package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;

public class DashboardPage extends BaseClass {

    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "welcome")
    public WebElement welcome;       // <== public WebElement welcome = driver.findElement(By.id("welcome"));
}
