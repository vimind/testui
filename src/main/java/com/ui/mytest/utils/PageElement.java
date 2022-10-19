package com.ui.mytest.utils;

import org.openqa.selenium.*;
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
        waitUntilElementToBePresent().click();
    }

    public WebElement waitUntilElementToBeClickable() {
        WebElement element = null;
        try {
            element = new WebDriverWait(driver, TIME_OUT).until(ExpectedConditions.elementToBeClickable(locator));
        } catch (StaleElementReferenceException | TimeoutException | InvalidElementStateException e) {
            e.printStackTrace();
        }
        return element;
    }

    public WebElement waitUntilElementToBePresent() {
        WebElement element = null;
        try {
            element = new WebDriverWait(driver, TIME_OUT).until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (StaleElementReferenceException | TimeoutException | InvalidElementStateException e) {
            e.printStackTrace();
        }
        return element;
    }

    public void enterData(CharSequence... charSequence) {
        waitUntilElementToBePresent().clear();
        waitUntilElementToBePresent().sendKeys(charSequence);
    }

    public String getText() {
        return waitUntilElementToBePresent().getText();
    }

    public void scrollIntoView() {
        waitUntilElementToBePresent();
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollToBottom() {
        waitUntilElementToBePresent();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
    }

}
