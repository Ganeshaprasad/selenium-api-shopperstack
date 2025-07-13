package com.shopperstack.ui;

import com.shopperstack.utils.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class HomePagePOM {

    private WebDriver driver;

    @FindBy(xpath = "//a[@class='active' and text()='Home']")
    private WebElement homePageName;

    @FindBy(xpath = "//div[contains(@class,'MuiAvatar-root')]")
    private WebElement userIcon;

    @FindBy(xpath = "//li[ normalize-space(.)='Logout']")
    private WebElement logOut;

    @FindBy(xpath = "//a[@id='home']/img")
    private WebElement headerLogo;

    public HomePagePOM(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public boolean isHomeLinkPresent() {
        return WaitUtility.waitForElementToBePresentAndClickable(driver,10,homePageName);
    }

    public void clickOnUserIcon() {
        userIcon.click();
    }

    public void clickOnLogout() {
        logOut.click();
    }

    public boolean isHeaderLogoPresent() {
        return WaitUtility.waitForElementToBePresentAndClickable(driver, 10, headerLogo);
    }
}
