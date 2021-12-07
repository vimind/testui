package com.ui.mytest.pages;

import com.ui.mytest.utils.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page class of Home page
 *
 * @author Vishwas
 */
public class FlightReservePage extends BasePage{

public static final By FLIGHTS_LIST = By.className("table");
public static final String CHOOSE_THIS_FLIGHT = "//td[text()='%s']/preceding-sibling::td/input[@value='Choose This Flight']";

public PageElement flightsList;
public PageElement chooseThisFlight;

public FlightReservePage(WebDriver driver){
    super(driver);
    flightsList = new PageElement(driver,FLIGHTS_LIST);
}

    /**
     * Click on Choose this flight button with respect to given airline
     * @param airline which need to be choose
     */
    public void clickOnChooseThisFlight(String airline){
    chooseThisFlight = new PageElement(driver,By.xpath( String.format(CHOOSE_THIS_FLIGHT,airline)));
    chooseThisFlight.click();
}

}
