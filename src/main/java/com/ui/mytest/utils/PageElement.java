package com.ui.mytest.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Wrapper Class for WebElement
 *
 * @author Vishwas
 */
public class PageElement {

    public final long TIME_OUT = 10;
    public WebDriver driver;
    public By locator;

    public PageElement(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public By getLocator() {
        return locator;
    }

    public WebElement getWebElement() {
        return driver.findElement(locator);
    }

    public void selectByVisibleText(String option) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(option);
    }

    public void click() {
        waitUntilElementToBeClickable(locator).click();
    }

    public WebElement waitUntilElementToBeClickable(By locator) {
        WebElement element = null;
        try {
            element = new WebDriverWait(driver, TIME_OUT).until(ExpectedConditions.elementToBeClickable(locator));
        } catch (StaleElementReferenceException | TimeoutException | InvalidElementStateException e) {
            e.printStackTrace();
        }
        return element;
    }

    public WebElement waitUntilElementToBePresent(By locator) {
        WebElement element =null;
        try {
            element =new WebDriverWait(driver, TIME_OUT).until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (StaleElementReferenceException | TimeoutException | InvalidElementStateException e) {
            e.printStackTrace();
        }
        return element;
    }

    public void enterData(CharSequence... charSequence){
        waitUntilElementToBePresent(locator).clear();
        waitUntilElementToBePresent(locator).sendKeys(charSequence);
    }

    public String getText() {
         return waitUntilElementToBePresent(locator).getText();
    }

}
