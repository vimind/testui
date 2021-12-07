package com.ui.mytest.pages;

import org.openqa.selenium.WebDriver;

/**
 * This is a Parent class for all the pages
 * @author Vishwas
 */
public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver){

    this.driver=driver;
    }
}
