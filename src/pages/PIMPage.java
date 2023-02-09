package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.BaseClass.*;

public class PIMPage {
    public PIMPage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "#menu_pim_viewPimModule")
    public WebElement  pimSection;
}
