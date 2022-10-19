package com.ui.mytest.utils;

import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * Test listener class which provide implementation for test failure, skip, pass status
 *
 * @author Vishwas
 */
@Slf4j
public class TestNGListener extends TestListenerAdapter {

    @Override
    public void onTestSuccess(ITestResult tr) {
        if (tr.getStatus() == ITestResult.SUCCESS) {
            log.info(tr.getTestClass().getName(), tr.getMethod().getMethodName() + " TEST PASSED");
        }
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        ITestContext context = tr.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("driver");
        if (tr.getStatus() == ITestResult.FAILURE) {
            log.info(tr.getTestClass().getName(), tr.getMethod().getMethodName() + " TEST FAILED");
            screenshot(driver);
        }
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        if (tr.getStatus() == ITestResult.SKIP) {
            log.info(tr.getTestClass().getName(), tr.getMethod().getMethodName() + " TEST SKIPPED");
        }
    }

    @Attachment(type = "image/png")
    public byte[] screenshot(WebDriver driver) throws NullPointerException {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
