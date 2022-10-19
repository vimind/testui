package com.ui.mytest.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

/**
 * This is a Parent class for all the pages
 *
 * @author Vishwas
 */
public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Log this step")
    public void loggingAssertionStep(Logger logger, String... text) {
        logger.info("Logging the assertion step:\n"+text);
    }

}
