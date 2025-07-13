package com.shopperstack.base;

import com.shopperstack.ui.HomePagePOM;
import com.shopperstack.ui.LoginPagePOM;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseLoggedInTest extends BaseUiTest {

    @BeforeMethod(alwaysRun = true)
    public void loginToApplication() {
        logger.info("**Starting login process...**");
    getDriver().manage().deleteAllCookies(); // Ensures no old login/session is reused
        try {
            LoginPagePOM loginPagePOM = new LoginPagePOM(getDriver());
            loginPagePOM.clickOnLogin();
            loginPagePOM.setEmail("ganesha.prasad1996@gmail.com");
            loginPagePOM.setPassword("Test@123");
            loginPagePOM.clickOnSignIn();

            HomePagePOM homePagePOM = new HomePagePOM(getDriver());
            Assert.assertTrue(homePagePOM.isHomeLinkPresent(), "Login failed — Home link not found after login");
            logger.info("**Login successful**");
        }   catch (Exception e) {
        logger.error("**Login Interrupted or failed **");
       // logger.error("Exception: ", e);
        throw e; // Re-throw to not hide the test failure
    }
    }

    @AfterMethod(alwaysRun = true)
    public void logOut(ITestResult result) {
        logger.info("**Starting logout process...**");
        try {

            if (result.getStatus() == ITestResult.SUCCESS) {
                HomePagePOM homePagePOM = new HomePagePOM(getDriver());
                homePagePOM.clickOnUserIcon();
                homePagePOM.clickOnLogout();
                logger.info("**Logout successful**");
            }
        }catch (Exception e)
        {
            logger.error("**Logout Interrupted and skipped**");
            //logger.error(" Exception: ", e);
            throw e;
        }

    }

}
