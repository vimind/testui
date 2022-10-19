package com.ui.mytest.pages;

import com.ui.mytest.utils.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.*;

/**
 * Page class of Home page
 *
 * @author Vishwas
 */
public class AmazonHomePage extends BasePage {
    // Locators
    public static final By HAMBURGER_MENU = By.id("nav-hamburger-menu");
    public static final String MENU_OPTIONS = "//a/div[text()='%s']";
    public static final String SUB_MENU_OPTIONS = "//a[text()='%s']";
    // Elements
    public PageElement hamburgerMenu;

    public AmazonHomePage(WebDriver driver) {
        super(driver);
        hamburgerMenu = new PageElement(driver, HAMBURGER_MENU);
    }

    /**
     * Click on hamburger menu
     */
    @Step("Click on Hamburger Menu")
    public void clickOnMenu() {
        hamburgerMenu.click();
    }

    /**
     * Click on Menu option
     * @param option in the menu
     */
    @Step("Select '{0}' from Shop by Category section in the menu")
    public void clickOnMenuOption(String option) {
        PageElement menuOption = new PageElement(driver, By.xpath(String.format(MENU_OPTIONS, option)));
        menuOption.scrollIntoView();
        menuOption.click();
    }

    /**
     * Click on Sub Menu option
     * @param option in the sub menu
     */
    @Step("Select '{0}' in the sub menu")
    public void clickOnSubMenuOption(String option) {
        PageElement subMenuOption = new PageElement(driver, By.xpath(String.format(SUB_MENU_OPTIONS, option)));
        subMenuOption.scrollIntoView();
        subMenuOption.click();
    }

}
