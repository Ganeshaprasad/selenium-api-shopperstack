package com.shopperstack.uitest;

import com.shopperstack.ui.HomePagePOM;
import com.shopperstack.ui.LoginPagePOM;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseLoggedInTest extends BaseUiTest {

    @BeforeMethod
    public void loginToApplication() {
        LoginPagePOM loginPagePOM = new LoginPagePOM(getDriver());
        loginPagePOM.clickOnLogin();
        loginPagePOM.setEmail("ganesha.prasad1996@gmail.com");
        loginPagePOM.setPassword("Ganesh@81");
        loginPagePOM.clickOnSignIn();

        HomePagePOM homePagePOM = new HomePagePOM(getDriver());
        System.out.println("login done ********************");
     
        Assert.assertTrue(homePagePOM.isHomeLinkPresent(), "Login failed — Home link not found after login");

    }

    @AfterMethod
    public void logOut(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            HomePagePOM homePagePOM = new HomePagePOM(getDriver());
            homePagePOM.clickOnUserIcon();
            homePagePOM.clickOnLogout();
        }
        System.out.println("logot done***********");
    }
}
