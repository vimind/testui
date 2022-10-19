package com.ui.mytest.tests;

import com.ui.mytest.utils.DriverFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * This is a Parent class for all the test classes
 *
 * @author Vishwas
 */
public class BasePageTest {

    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite(ITestContext context) {
        DriverFactory.createWebDriver("Chrome");
        driver = DriverFactory.getWebDriver();
        context.setAttribute("driver", driver);
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void afterSuite() {
        driver.close();
        driver.quit();
    }
}
