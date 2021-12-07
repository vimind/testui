package com.ui.mytest.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class is to Retry Failed Test Cases
 *
 * @author Vishwas
 */
public class RetryTest implements IRetryAnalyzer {

    private int retryCount = 0;
    // Maximum times the failed test cases retry is 2
    private int maxRetryCount = 2;

    /**
     * Determine if maximum number of retries have been used
     * @param result testResult of test class
     * @return true if another retry is allowed; false if all retry attempts have been used
     */
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}