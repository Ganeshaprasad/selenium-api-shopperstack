package com.shopperstack.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility {
     WebDriverWait wait;

    public static void waitForPageToLoad(WebDriver driver, int time) {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));

        wait.until(driver1 -> {
            JavascriptExecutor js = (JavascriptExecutor) driver1;
            String state = js.executeScript("return document.readyState").toString();
            return state.equals("complete");

        });
    }

    public static void waitForPageLoad(WebDriver driver) {
        waitForPageToLoad(driver, 10);
    }
}
