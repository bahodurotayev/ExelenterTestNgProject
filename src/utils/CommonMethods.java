package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static utils.BaseClass.driver;
public class CommonMethods{
    /**
     * Method will switch focus to next window/tab based on the window title/name
     * @param windowTitle String
     */
    public static void switchToWindow(String windowTitle) {
        Set<String> windows = driver.getWindowHandles();
        for (String windowOrTab : windows) {
            String title = driver.switchTo().window(windowOrTab).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Window is found! Page Title: " + driver.getTitle() +  " URL: " + driver.getCurrentUrl());
                break;
            }
        }
    }

    public static void send_Text(WebElement element, String string){
        wait_element().until(ExpectedConditions.elementToBeClickable(element)).clear();
        wait_element().until(ExpectedConditions.elementToBeClickable(element)).sendKeys(string);

    }

    public static void click_Button(WebElement element){
        element.click();
    }

    public static WebDriverWait wait_element(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICIT_WAIT_TIME));
        return wait;
    }
    public static void wait_presence_element(By by){
        wait_element().until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public static void wait_for_click(WebElement element){
        wait_element().until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void click_clickAbility(WebElement element){
        wait_for_click(element);
        element.click();
    }

    public static void wait_visibility(WebElement element){
        wait_element().until(ExpectedConditions.visibilityOf(element));
    } public static void wait_visibility(By locator){
        wait_element().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitSecond(int second){
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void click_radio_or_checkbox(List<WebElement> elements, String expected) {
        for (WebElement eachElement: elements) {
            String actualValue = eachElement.getAttribute("value");
            if (actualValue.equals(expected)){
                eachElement.click();
                break;
            }
        }
    }
    public static void click_radio_or_checkbox(WebElement element) {
     if (element.isEnabled() && !element.isSelected()){
         element.click();
     }
    }
    public static void selectValue(WebElement element,String String) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        for (WebElement each: options) {
            if (each.getText().equalsIgnoreCase(String)){
                select.selectByVisibleText(String);
                break;
            }
        }
    }
    public static void selectValue(List<WebElement> elements, String expected){
        for (WebElement each: elements
        ) {
            String actual = each.getText();
            if(actual.equals(expected)){
                each.click();
                break;
            }
        }
    }
    public static void selectValue(WebElement elements, int index){
        Select select = new Select(elements);
        List<WebElement> options = select.getOptions();
        for (WebElement each : options) {
            if(index < options.size()){
                select.selectByIndex(index);
            }else {
                try {
                    throw new IndexOutOfBoundsException(index);
                }catch (IndexOutOfBoundsException exception){
                    exception.printStackTrace();
                    System.out.println("Incorrect index !!!.Please use index between 1 and " + options.size());
                }
            }
        }
    }
    public static void acceptAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public static void dismissAlert(){
         driver.switchTo().alert().dismiss();
    }

    public static void sendTextAlert(String string){
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(string);
    }
    public static String getAlertText() {
        String alertText = null;
        try {
            alertText = driver.switchTo().alert().getText();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
        return alertText;
    }

    public static void screenshot(WebElement quickLaunch, String str) {
        waitSecond(2);
        File sourceFile = quickLaunch.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(sourceFile, new File("screenshots/"+str+".png"));
        }catch (IOException exception){
            exception.printStackTrace();
            System.out.println("Unable to take screenshot");
        }
    }
    public static void screenshotFull(String str) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(sourceFile, new File("screenshots/"+str+".png"));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("ScreenShot is not taken");
        }
    }
    public static void scrollToParagraph(int index, By by) {
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        while (getNumberOfParagraphs(by) < index) {
            jsExecutor().executeScript(script); // scroll down by one <p>
        }
        System.out.println("Total paragraphs: " + getNumberOfParagraphs(by));
    }

    public static int getNumberOfParagraphs(By by) {
        //List<WebElement> paragraphs = driver.findElements(By.className("jscroll-added"));
        return driver.findElements(by).size();
    }

    public static JavascriptExecutor jsExecutor() {
        return (JavascriptExecutor) driver;
    }

    /**
     * Method performs simple click based on Javascript. Use this if regular Selenium click fails.
     *
     * @param element WebElement that needs to be clicked on.
     */
    public static void jsClick(WebElement element) {
        jsExecutor().executeScript("arguments[0].click();", element);
    }

    /**
     * Method will scroll to the given element
     *
     * @param element WebElement to get scrolled to
     */
    public static void scrollToElement(WebElement element) {
        jsExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Method will scroll both vertically (left & right) and horizontally (up & down) based on given pixels.
     *
     * @param horizontalPixel int
     * @param verticalPixel   int
     */
    public static void scrollToElement(int horizontalPixel, int verticalPixel) {
        jsExecutor().executeScript("window.scrollBy(" + horizontalPixel + "," + verticalPixel + ")");
    }

    /**
     * Method will scroll down in accordance with the passed pixel as parameter
     *
     * @param pixel int
     */
    public static void scrollDown(int pixel) {
        jsExecutor().executeScript("window.scrollBy(0," + pixel + ")");  // "window.scrollBy(0,500)"
    }

    /**
     * Method will scroll up based on given pixel
     *
     * @param pixel int
     */
    public static void scrollUp(int pixel) {
        jsExecutor().executeScript("window.scrollBy(0,-" + pixel + ")"); // "window.scrollBy(0,-500)"
    }

    public static String randomStrongPassWord(){
        String passWord = "";
        Random rnd = new Random();
        String lowerLetter = "abcdefghijklmnoprstuwxyz";
        String capitalLetters = "ABCDEFGHIJKLMNOPRSTUWXYZ";
        String specialChar = "!#$%&()*+,-.:;<=>?@[]^_{|}~";
        while (passWord.length() < 12){
            passWord += lowerLetter.charAt(rnd.nextInt(lowerLetter.length()));
            passWord += capitalLetters.charAt(rnd.nextInt(capitalLetters.length()));
            passWord += specialChar.charAt(rnd.nextInt(specialChar.length()));
            passWord += rnd.nextInt(10);
        }
        return passWord;
    }

}
