package com.shopperstack.support;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.shopperstack.base.BaseUiTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation extends BaseUiTest implements ITestListener {

    private static final Logger logger = LogManager.getLogger(ListenerImplementation.class);

    ExtentReports extentReports;
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        String testName = result.getMethod().getMethodName();
        String className = result.getTestClass().getName();

        logger.info("**Test started: " + result.getMethod().getMethodName() + "**");

        //Extent report
        ExtentTest extentTest = extentReports.createTest(className + " :: " + testName);
        test.set(extentTest);

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("**Test passed: " + result.getMethod().getMethodName() + "**");

        //extent report
        test.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("**Test failed: " + result.getMethod().getMethodName() + "**");
        logger.error("**Exception: ", result.getThrowable() + "**");
        //code to take screenshot when test fails
        ScreenShotUtility.takesScreenShotWhenTestFails(result.getMethod().getMethodName());

        //extent report
        test.get().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("**Test skipped: " + result.getMethod().getMethodName() + "**");

        //extent report
        test.get().skip("Test skipped");
    }


    @Override
    public void onStart(ITestContext context) {
        logger.info("**Suite started: " + context.getName() + "**");

        //Extent report
        String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setReportName("Shopper stack Automation result");
        reporter.config().setDocumentTitle("Test Execution Report");
        reporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Tester", "Ganesh");
        extentReports.setSystemInfo("Browser", context.getCurrentXmlTest().getParameter("browser"));
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("**Suite finished: " + context.getName() + "**");
        extentReports.flush();
    }
}
