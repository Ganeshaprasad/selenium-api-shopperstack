package com.shopperstack.uitest;

import com.shopperstack.ui.HomePagePOM;
import com.shopperstack.ui.LoginPagePOM;
import com.shopperstack.utils.WaitUtility;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class BaseUiTest {

    // Created ThreadLocal instance to maintain a separate WebDriver per thread (for parallel execution)
    private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();




    // Thread-safe way to get the WebDriver for the current thread
    protected static WebDriver getDriver() {
        return THREAD_LOCAL.get();
    }


    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setup(String browser) {


            if (browser.equalsIgnoreCase("chrome")) {
                THREAD_LOCAL.set(new ChromeDriver());
            } else if (browser.equalsIgnoreCase("firefox")) {
                THREAD_LOCAL.set(new FirefoxDriver());
            }

            getDriver().manage().window().maximize();
            getDriver().get("https://www.shoppersstack.com/");

            //TODO Need to remove this method, its not needed
            // WaitUtility.waitForPageLoad(getDriver());



    }

    @AfterMethod(alwaysRun = true)
    public void teardown(ITestContext context) {
        getDriver().quit();
        THREAD_LOCAL.remove();


    }


}
