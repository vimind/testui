package com.ui.mytest.pages;

import com.ui.mytest.utils.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page class of Home page
 *
 * @author Vishwas
 */
public class AmazonProductPage extends BasePage {
    // Locators
    public static final By ABOUT_THIS_ITEM = By.cssSelector("#feature-bullets h1");
    public static final By ABOUT_THIS_ITEM_SECTION_TEXT = By.cssSelector("#feature-bullets ul");
    // Elements
    public PageElement aboutThisItemLabel;
    public PageElement aboutThisItemSectionText;

    public AmazonProductPage(WebDriver driver) {
        super(driver);
        aboutThisItemLabel = new PageElement(driver, ABOUT_THIS_ITEM);
        aboutThisItemSectionText = new PageElement(driver, ABOUT_THIS_ITEM_SECTION_TEXT);
    }

}
