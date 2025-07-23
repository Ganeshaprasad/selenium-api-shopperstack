package com.shopperstack.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class TestPOM {
    @FindAll({
            @FindBy(id = "submitBtn"),
            @FindBy(name = "continue")
    })
    private WebElement submitButton;
}
