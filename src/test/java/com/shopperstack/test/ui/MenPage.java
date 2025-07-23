package com.shopperstack.test.ui;

import com.shopperstack.base.BaseLoggedInTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class MenPage extends BaseLoggedInTest {
    WebDriver driver;
    @Test
    public void dummyTest() throws IOException {
        List<WebElement> elements = driver.findElements(By.className("btn"));
        System.out.println(elements.getClass().getName());
    }
}
