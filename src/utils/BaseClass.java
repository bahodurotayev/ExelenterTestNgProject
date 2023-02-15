package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import static utils.PageInitializer.initialize;

public class BaseClass extends CommonMethods {
    public static WebDriver driver;
    @BeforeMethod
    public static void setUp(){
        ConfigReader.loadProperties(Constant.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getProperties("chrome").toLowerCase()) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_PATH);
                driver = new ChromeDriver();
            }
            case "edge" -> {
                System.setProperty("webdriver.edge.verboseLogging", Constant.EDGE_DRIVER_PATH);
                driver = new EdgeDriver();
            }
            default -> throw new RuntimeException("Browser is not supported");
        }

        //driver.get(ConfigReader.getProperties("url"));
        //driver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");
        driver.get(ConfigReader.getProperties("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constant.IMPLICIT_WAIT_TIME));
        initialize();
    }
    @AfterMethod
    public static void tearDown(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        if (driver != null) {     // This line is optional. We only use it to prevent NullPointerException.
            driver.quit();
        }
    }
}
