package com.kryviak.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static final String BASE_URL = "https://mail.google.com/";
    private static final String SYSTEM_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String SYSTEM_DRIVER_PATH = "src\\main\\resources\\chromedriver.exe";

    private static DriverManager driverManagerInstance = new DriverManager();
    private WebDriver webDriver = null;

    private DriverManager() { }

    public static DriverManager getInstance() {
        if(driverManagerInstance == null) {
            driverManagerInstance = new DriverManager();
        }
        return driverManagerInstance;
    }

    public WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = new ChromeDriver();
            System.setProperty(SYSTEM_DRIVER_PROPERTY, SYSTEM_DRIVER_PATH);
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            webDriver.manage().window().maximize();
            webDriver.get(BASE_URL);
        }
            return webDriver;
    }

    public void waitForElementVisible(By by) {
        (new WebDriverWait(DriverManager.getInstance().getWebDriver(), 3))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void closeWebDriver() {
        webDriver.quit();
    }
}