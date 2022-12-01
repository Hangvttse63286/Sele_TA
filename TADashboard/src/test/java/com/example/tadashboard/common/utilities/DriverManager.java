package com.example.tadashboard.common.utilities;

import com.example.tadashboard.common.constant.Browser;
import com.example.tadashboard.common.utilities.helpers.ConfigFileReader;
import com.example.tadashboard.dataObjects.Url;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver() {
        Browser browserType;
        String configBrowser = ConfigFileReader.getValue("browser");
        try {
            browserType = Browser.fromString(configBrowser);
            switch (browserType) {
                case CHROME:
                    driver = initChromeDriver();
                    break;
                case FIREFOX:
                    driver = initFirefoxDriver();
                    break;
                default:
                    System.out.println("Browser: " + browserType.name() + " is invalid, Launching Chrome as browser of choice...");
                    driver = initChromeDriver();
                    break;
            }
        } catch (Exception e) {
            System.out.println("Browser: " + configBrowser + " is invalid, Launching Chrome as browser of choice...");
            driver = initChromeDriver();
        }
    }

    private static WebDriver initChromeDriver() {
        System.out.println("Launching Chrome browser...");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + ConfigFileReader.getValue("driverPath") + "chromedriver.exe");
        return new ChromeDriver();
    }

    private static WebDriver initFirefoxDriver() {
        System.out.println("Launching Firefox browser...");
        System.setProperty("webdriver.gecko.driver", Utilities.getProjectPath() + ConfigFileReader.getValue("driverPath") + "geckodriver.exe");
        return new FirefoxDriver();
    }

    public static void open(Url url) {
        driver.get(url.getUrl());
    }

    public static void pageLoadTimeout() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigFileReader.getValue("pageLoadTimeout"))));
    }

    public static void implicitlyWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigFileReader.getValue("implicitlyWait"))));
    }

    public static void setImplicitlyWait(long duration) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
    }

    private static WebDriverWait explicitlyWait(long duration) {
        return new WebDriverWait(driver, Duration.ofSeconds(duration));
    }

    public static void waitVisibility(By by, long duration) {
        explicitlyWait(duration).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement waitToBeClickable(WebElement element, long duration) {
        return explicitlyWait(duration).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static Boolean waitToBeSelected(By by, long duration) {
        return explicitlyWait(duration).until(ExpectedConditions.elementToBeSelected(by));
    }

    public static void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public static void clearAllCookies() {
        driver.manage().deleteAllCookies();
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    private static Alert switchToAlert() {
        return driver.switchTo().alert();
    }

    public static String getAlertMsg() {
        return switchToAlert().getText();
    }

    public static Boolean isAlertDisplayed(long duration) {
        try {
            explicitlyWait(duration).until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static void acceptAlert() {
        switchToAlert().accept();
    }

    public static void dismissAlert() {
        switchToAlert().dismiss();
    }

    public static void scrollToView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
    }

    public static void quit() {
        driver.quit();
    }

    public static WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public static List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public static void moveToElement(WebElement element) {
        explicitlyWait(2).until(ExpectedConditions.elementToBeClickable(element));
        new Actions(driver).moveToElement(element).perform();
    }

    public static String getPageTitle() {
        return driver.getTitle();
    }
}
