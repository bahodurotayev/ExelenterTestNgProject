package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.BaseClass.driver;

public class LoginPageNoPageFactory {
    public WebElement username = driver.findElement(By.id("txtUsername"));
    public WebElement password = driver.findElement(By.id("txtPassword"));
    public WebElement loginBtn = driver.findElement(By.id("btnLogin"));
    public WebElement homepageLogo = driver.findElement(By.cssSelector("#divLogo img"));
}
