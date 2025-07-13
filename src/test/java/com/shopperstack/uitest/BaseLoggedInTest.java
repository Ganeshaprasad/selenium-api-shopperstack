package com.shopperstack.uitest;

import com.shopperstack.ui.HomePagePOM;
import com.shopperstack.ui.LoginPagePOM;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseLoggedInTest extends BaseUiTest {

    @BeforeMethod(alwaysRun = true)
    public void loginToApplication() {
    getDriver().manage().deleteAllCookies(); // ✅ Ensures no old login/session is reused
        LoginPagePOM loginPagePOM = new LoginPagePOM(getDriver());
        loginPagePOM.clickOnLogin();
        loginPagePOM.setEmail("ganesha.prasad1996@gmail.com");
        loginPagePOM.setPassword("Test@123");
        loginPagePOM.clickOnSignIn();

        HomePagePOM homePagePOM = new HomePagePOM(getDriver());
      //  System.out.printf("[%s] setup done ******************%n", Thread.currentThread().getName());

        Assert.assertTrue(homePagePOM.isHomeLinkPresent(), "Login failed — Home link not found after login");

    }

    @AfterMethod(alwaysRun = true)
    public void logOut(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            HomePagePOM homePagePOM = new HomePagePOM(getDriver());
            homePagePOM.clickOnUserIcon();
            homePagePOM.clickOnLogout();
        }
       // System.out.printf("[%s] setup done ******************%n", Thread.currentThread().getName());
    }

}
