package com.shopperstack.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility {
     WebDriverWait wait;

     @Deprecated
    public static void waitForPageToLoad(WebDriver driver, int time) {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));

        wait.until(driver1 -> {
            JavascriptExecutor js = (JavascriptExecutor) driver1;
            String state = js.executeScript("return document.readyState").toString();
            return state.equals("complete");

        });
    }

    @Deprecated
    public static void waitForPageLoad(WebDriver driver) {
        waitForPageToLoad(driver, 10);
    }

    public static boolean waitForElementToBePresentAndClickable(WebDriver driver, int time, WebElement element)
    {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
             wait.until(ExpectedConditions.elementToBeClickable(element));
             return element.isDisplayed();
        }catch (RuntimeException e)
        {
            return false;
        }
    }

    public static boolean waitAndClickFluently(WebDriver driver,WebElement element,int time)
    {
        try {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(time))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(ElementClickInterceptedException.class)
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            return true;
        }catch (Exception e)
        {
            return false;
        }


    }
}
