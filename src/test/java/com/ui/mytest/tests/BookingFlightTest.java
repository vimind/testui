package com.ui.mytest.tests;

import java.util.HashMap;
import java.util.Map;

import com.ui.mytest.pages.FlightReservePage;
import com.ui.mytest.pages.HomePage;
import com.ui.mytest.pages.PurchasePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * This class contains tests with respect to Booking Flights
 * @author Vishwas
 */
public class BookingFlightTest extends BasePageTest{

    HomePage homePage;
    FlightReservePage flightReservePage;
    PurchasePage purchasePage;
    Map<String, Object> passengerInfo = new HashMap<>();

    @BeforeClass
    public void beforeClass(){

        homePage= new HomePage(driver);
        flightReservePage= new FlightReservePage(driver);
        purchasePage= new PurchasePage(driver);

    }

    /**
     * Test to book flight
     */
    @Test
    public void testBookingFlights(){
        SoftAssert softAssert = new SoftAssert();
        String purchaseConfirmMsg = "Thank you for your purchase today!";
        // Prepare data
        homePage.fromPort.selectByVisibleText("Paris");
        homePage.toPort.selectByVisibleText("Berlin");
        homePage.findFlights.click();
        passengerInfo.put("Name","TestUser");
        passengerInfo.put("Address","12th cross Whitefield");
        passengerInfo.put("City","Bengaluru");
        passengerInfo.put("State","Karnataka");
        passengerInfo.put("Zip Code",560066);
        passengerInfo.put("Card Type","Visa");
        passengerInfo.put("Credit Card Number",1234567890);
        passengerInfo.put("Month",01);
        passengerInfo.put("Year",2022);
        passengerInfo.put("Name on Card","TestUser");

        // Purchase confirm
        flightReservePage.clickOnChooseThisFlight("United Airlines");
        softAssert.assertEquals(purchasePage.makePurchase(passengerInfo),purchaseConfirmMsg, "Purchase Confirm Message");

        // Assert All
        softAssert.assertAll();
    }
}
