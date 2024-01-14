package com.cucumbercraft.framework;




import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class AbstractPage {

    private int DriverWaitTime = 35;
    private static final int DEBUG_WAIT = 1000;
    private static final String LOG_CONTEXT = "context";

    public static WebDriver getDriver;
    public HashMap<String, WebElement> commonElements = new HashMap<>();

    public AbstractPage() {
        if (System.getProperty("DriverWaitTime") != null) {
            DriverWaitTime = Integer.valueOf(System.getProperty("DriverWaitTime"));
        }
        getDriver= DriverManager.getWebDriver();

    }



    public WebElement waitForElementVisible(final By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver, DriverWaitTime);
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (UnhandledAlertException | NoAlertPresentException e) {
            getDriver.switchTo().alert().dismiss();
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }
    }

    public List<WebElement> waitForElementsVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver, DriverWaitTime);
        try {
            return this.findElements(by);
        } catch (UnhandledAlertException | NoAlertPresentException e) {
            return findElements(by);
        }
    }

    public List<WebElement> findElements(By by)
    {
        return getDriver.findElements(by);
    }
    public void waitForPageLoad() throws InterruptedException {
        Thread.sleep(2000L);
    }

    public void switchToFrameById(WebElement wbFrame) {
        getDriver.switchTo().frame(wbFrame);
    }

    public void switchToDefault() {
        getDriver.switchTo().defaultContent();
    }

    public void switchToLastOpenWindow() {
        Set<String> handles = getDriver.getWindowHandles();
        if (!handles.isEmpty()) {
            String handle = handles.toArray()[handles.size() - 1].toString();
            getDriver.switchTo().window(handle);
        }
    }

}

