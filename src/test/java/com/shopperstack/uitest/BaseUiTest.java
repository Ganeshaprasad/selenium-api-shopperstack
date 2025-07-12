package com.shopperstack.uitest;

import com.shopperstack.utils.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseUiTest {

    // Created ThreadLocal instance to maintain a separate WebDriver per thread (for parallel execution)
    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    protected static WebDriver getDriver() {
        return threadLocal.get();
    }

    static WebDriver driver=getDriver();
    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            threadLocal.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("firefox")) {
            threadLocal.set(new FirefoxDriver());
        }

        getDriver().manage().window().maximize();
        getDriver().get("https://www.shoppersstack.com/");
        WaitUtility.waitForPageLoad(getDriver());

        System.out.println("set up done******************");
    }

    @AfterMethod
    public void teardown()
    {
        getDriver().quit();
        threadLocal.remove();
        System.out.println("tear down done*************");
    }
}
