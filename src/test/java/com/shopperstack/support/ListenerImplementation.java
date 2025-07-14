package com.shopperstack.support;

import com.shopperstack.base.BaseUiTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation extends BaseUiTest implements ITestListener {

    private static final Logger logger = LogManager.getLogger(ListenerImplementation.class);
    @Override
    public void onTestStart(ITestResult result) {
        logger.info("**Test started: " + result.getMethod().getMethodName()+"**");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("**Test passed: " + result.getMethod().getMethodName()+"**");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("**Test failed: " + result.getMethod().getMethodName()+"**");
        logger.error("**Exception: ", result.getThrowable()+"**");

        //code to take screenshot when test fails
        ScreenShotUtility.takesScreenShotWhenTestFails(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("**Test skipped: " + result.getMethod().getMethodName()+"**");
    }



    @Override
    public void onStart(ITestContext context) {
        logger.info("**Suite started: " + context.getName()+"**");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("**Suite finished: " + context.getName()+"**");
    }
}
