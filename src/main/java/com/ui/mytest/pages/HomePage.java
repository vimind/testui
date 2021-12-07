package com.ui.mytest.pages;

import com.ui.mytest.utils.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page class of Home page
 *
 * @author Vishwas
 */
public class HomePage extends BasePage{

public static final By FROM_PORT = By.name("fromPort");
public static final By TO_PORT = By.name("toPort");
public static final By FIND_FLIGHTS = By.cssSelector("[value='Find Flights']");

public PageElement fromPort;
public PageElement toPort;
public PageElement findFlights;


public HomePage(WebDriver driver){
    super(driver);
    fromPort = new PageElement(driver,FROM_PORT);
    toPort = new PageElement(driver,TO_PORT);
    findFlights = new PageElement(driver,FIND_FLIGHTS);
}

}
