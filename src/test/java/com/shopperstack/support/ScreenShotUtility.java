package com.shopperstack.support;

import com.shopperstack.base.BaseUiTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ScreenShotUtility {

    public static void takesScreenShotWhenTestFails(String testName)
    {
        TakesScreenshot screenshot = (TakesScreenshot) BaseUiTest.getDriver();
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        File  dest =new File("./screenshot/"+testName+"_"+timestamp+".png");
        try {
            FileUtils.copyFile(src,dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
