package com.shopperstack.ui;

import com.shopperstack.utils.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePOM {

    @FindBys({
            @FindBy(tagName = "div"),
            @FindBy(className = "login-form")
    })















private WebDriver driver;

    @FindBy(xpath = "//button[@id='loginBtn']")
    private WebElement logInButton;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailBox;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordBox;

    @FindBy(xpath = "//span[text()='Login']")
    private WebElement logIn;

    public LoginPagePOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    public void clickOnLogin()
    {
       if( !WaitUtility.waitAndClickFluently(driver,logInButton,10)) {
           throw new RuntimeException("Element Not clickable");
       }
    }

    public void setEmail(String email)
    {
        emailBox.sendKeys(email);
    }

    public void setPassword(String password)
    {
        passwordBox.sendKeys(password);
    }

    public void clickOnSignIn()
    {
        logIn.click();
    }

}
