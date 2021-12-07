package com.ui.mytest.pages;

import java.util.Map;

import com.ui.mytest.utils.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page class of Purchase page
 *
 * @author Vishwas
 */
public class PurchasePage extends BasePage {

    public static final By NAME = By.id("inputName");
    public static final By ADDRESS = By.id("address");
    public static final By CITY = By.id("city");
    public static final By STATE = By.id("city");
    public static final By ZIP_CODE = By.id("zipCode");
    public static final By CARD_TYPE = By.id("cardType");
    public static final By CREDIT_CARD_NUMBER = By.id("creditCardNumber");
    public static final By CREDIT_CARD_MONTH = By.id("creditCardMonth");
    public static final By CREDIT_CARD_YEAR = By.id("creditCardYear");
    public static final By NAME_ON_CARD = By.id("nameOnCard");
    public static final By PURCHASE_FLIGHT = By.cssSelector("[value='Purchase Flight']");
    public static final By PURCHASE_CONFIRMATION = By.tagName("h1");

    public PageElement nameElement;
    public PageElement addressElement;
    public PageElement cityElement;
    public PageElement stateElement;
    public PageElement zipCodeElement;
    public PageElement cardTypeElement;
    public PageElement creditCardNumberElement;
    public PageElement creditCardMonthElement;
    public PageElement creditCardYearElement;
    public PageElement nameOnCardElement;
    public PageElement purchaseFlight;
    public PageElement purchaseConfirmation;

    public PurchasePage(WebDriver driver) {
        super(driver);
        nameElement = new PageElement(driver, NAME);
        addressElement = new PageElement(driver, ADDRESS);
        cityElement = new PageElement(driver, CITY);
        stateElement = new PageElement(driver, STATE);
        zipCodeElement = new PageElement(driver, ZIP_CODE);
        cardTypeElement = new PageElement(driver, CARD_TYPE);
        creditCardNumberElement = new PageElement(driver, CREDIT_CARD_NUMBER);
        creditCardMonthElement = new PageElement(driver, CREDIT_CARD_MONTH);
        creditCardYearElement = new PageElement(driver, CREDIT_CARD_YEAR);
        nameOnCardElement = new PageElement(driver, NAME_ON_CARD);
        purchaseFlight = new PageElement(driver, PURCHASE_FLIGHT);
        purchaseConfirmation = new PageElement(driver, PURCHASE_CONFIRMATION);
    }

    public void setName(String name) {
        nameElement.enterData(name);
    }

    public void setAddress(String address) {
        addressElement.enterData(address);
    }

    public void setCity(String city) {
        cityElement.enterData(city);
    }

    public void setState(String state) {
        stateElement.enterData(state);
    }

    public void setZipCode(int zipCode) {
        zipCodeElement.enterData(String.valueOf(zipCode));
    }

    public void setCardType(String cardType) {
        cardTypeElement.selectByVisibleText(cardType);
    }

    public void setCreditCardNumber(long creditCardNumber) {
        creditCardNumberElement.enterData(String.valueOf(creditCardNumber));
    }


    public void setCreditCardMonth(int creditCardMonth) {
        creditCardMonthElement.enterData(String.valueOf(creditCardMonth));
    }

    public void setCreditCardYear(int creditCardYear) {
        creditCardYearElement.enterData(String.valueOf(creditCardYear));
    }

    /**
     * Enter Name on the card
     * @param nameOnCard name on the card
     */
    public void setNameOnCardElement(String nameOnCard) {
        nameOnCardElement.enterData(nameOnCard);
    }

    /**
     * Book a flight with given data
     * @param passengerInfo information of passenger
     * @return the purchase confirmation message as String
     */
    public String makePurchase(Map<String, Object> passengerInfo){

        for(Map.Entry<String, Object> info: passengerInfo.entrySet()){
            switch(info.getKey()){
                case "Name":
                        setName((String)info.getValue());
                        break;
                case "Address":
                    setAddress((String)info.getValue());
                    break;
                case "City":
                    setCity((String)info.getValue());
                    break;
                case "State":
                    setState((String) info.getValue());
                    break;
                case "Zip Code":
                    setZipCode(Integer.parseInt(String.valueOf(info.getValue())));
                    break;
                case "Card Type":
                    setCardType((String) info.getValue());
                    break;
                case "Credit Card Number":
                    setCreditCardNumber(Long.parseLong(String.valueOf( info.getValue())));
                    break;
                case "Month":
                    setCreditCardMonth(Integer.parseInt(String.valueOf(info.getValue())));
                    break;
                case "Year":
                    setCreditCardYear(Integer.parseInt(String.valueOf(info.getValue())));
                    break;
                    case "Name on Card":
                    setNameOnCardElement((String) info.getValue());
                    break;
            }
        }
        purchaseFlight.click();
        return purchaseConfirmation.getText();
}
}
