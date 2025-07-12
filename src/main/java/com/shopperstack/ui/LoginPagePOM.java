package com.shopperstack.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePOM {
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
       logInButton.click();
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
