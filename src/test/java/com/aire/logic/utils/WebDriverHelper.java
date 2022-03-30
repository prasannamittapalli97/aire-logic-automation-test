package com.aire.logic.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverHelper {

    private static WebDriver driver;

    private static final int WAIT_TIME = 3;

    private WebDriverHelper() {}

    public static WebDriver getWebDriverInstance(boolean isNewDriverRequired) {
        System.out.println("Driver instance:"+driver);
        if (driver == null || isNewDriverRequired) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void waitForWebElementTobePresent(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));;
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

}
