package com.shopperstack.base;

import com.shopperstack.ui.HomePagePOM;
import com.shopperstack.ui.LoginPagePOM;
import com.shopperstack.utils.WaitUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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


    protected final Logger logger = LogManager.getLogger(getClass());

    // Thread-safe way to get the WebDriver for the current thread
    protected static WebDriver getDriver() {
        return THREAD_LOCAL.get();
    }


    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setup(String browser) {


            if (browser.equalsIgnoreCase("chrome")) {
                THREAD_LOCAL.set(new ChromeDriver());
                logger.info("**Chrome browser Launched**");
            } else if (browser.equalsIgnoreCase("firefox")) {
                THREAD_LOCAL.set(new FirefoxDriver());
                logger.info("**Firefox browser Launched**");
            }

            getDriver().manage().window().maximize();
        logger.info("**Window maximised**");
            getDriver().get("https://www.shoppersstack.com/");
        logger.info("**Enter the URL**");

            //TODO Need to remove this method, its not needed
            // WaitUtility.waitForPageLoad(getDriver());



    }

    @AfterClass(alwaysRun = true)
    public void teardown(ITestContext context) {

        getDriver().quit();
        logger.info("**Browser closed**");
        THREAD_LOCAL.remove();


    }


}
