package com.ui.mytest.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IConfigurable;
import org.testng.IConfigureCallBack;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

/**
 * This class used to modify a TestNG annotation read from your test classes.
 * @author Vishwas
 */
public class AnnotationTransformerClass implements IAnnotationTransformer, IConfigurable {

    /**
     * Add retry annotation at runtime
     * @param testAnnotation annotation
     * @param testClass class name
     * @param testConstructor constructor of class
     * @param testMethod method need to transform parameters
     */
    @Override
    public void transform(ITestAnnotation testAnnotation, Class testClass, Constructor testConstructor, Method testMethod) {
        testAnnotation.setRetryAnalyzer(RetryTest.class);
    }

    /**
     * Retry configuration methods like Before/After Class, Before/After Method to execute if it fails
     * @param callBack variable of IConfigureCallBack interface
     * @param testResult test result
     */
    @Override
    public void run(final IConfigureCallBack callBack, final ITestResult testResult) {
        for (int i = 0; i < 2; i++) {
            callBack.runConfigurationMethod(testResult);
            if (testResult.getThrowable() == null) {
                break;
            }
        }
    }
}