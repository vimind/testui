package com.ui.mytest.tests;

import com.ui.mytest.utils.DriverFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

/**
 * This is a Parent class for all the test classes
 * @author Vishwas
 */
public class BasePageTest {

    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite(ITestContext context){
        DriverFactory.createWebDriver("Chrome");
        driver = DriverFactory.getWebDriver();
        context.setAttribute("driver", driver);
        driver.get("https://blazedemo.com");
    }


    @AfterSuite
    public void afterSuite(){
        driver.close();
       driver.quit();
    }
}
