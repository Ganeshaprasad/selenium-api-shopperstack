package com.shopperstack.uitest;

import com.shopperstack.ui.HomePagePOM;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseLoggedInTest {
    private HomePagePOM homePagePOM;

    @BeforeMethod
    private void setUpPage() {
        homePagePOM = new HomePagePOM(getDriver());
    }

    @Test
    public void verifyThePresenceOfHeaderLogo() {
        System.out.println("home page test ******************");
        Assert.assertTrue(homePagePOM.isHeaderLogoPresent(), "Logo not present");
    }
}
