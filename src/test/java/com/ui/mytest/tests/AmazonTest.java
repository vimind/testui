package com.ui.mytest.tests;

import com.ui.mytest.pages.AmazonHomePage;
import com.ui.mytest.pages.AmazonProductPage;
import com.ui.mytest.pages.AmazonResultsPage;
import io.qameta.allure.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains tests with respect to Amazon Test
 *
 * @author Vishwas
 */
public class AmazonTest extends BasePageTest {
    public static Logger logger = LoggerFactory.getLogger(AmazonTest.class);
    AmazonHomePage amazonHomePage;
    AmazonResultsPage amazonResultsPage;
    AmazonProductPage amazonProductPage;

    @BeforeClass
    public void beforeClass() {
        amazonHomePage = new AmazonHomePage(driver);
        amazonResultsPage = new AmazonResultsPage(driver);
        amazonProductPage = new AmazonProductPage(driver);
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the 'About this item' in the Product page")
    @Story("Test to verify Search for product TV")
    @Test(description = "Test to verify 'About this item' text is present in the Product page")
    public void testTVSearch() {
        SoftAssert softAssert = new SoftAssert();
        amazonHomePage.clickOnMenu();
        amazonHomePage.clickOnMenuOption("TV, Appliances, Electronics");
        amazonHomePage.clickOnSubMenuOption("Televisions");
        amazonResultsPage.selectTVBrand("Samsung");
        amazonResultsPage.selectSortByOption("Price: High to Low");
        String defaultTab = driver.getWindowHandle();
        amazonResultsPage.clickOnSearchItem(2);
        List<String> windows = new ArrayList<String>(driver.getWindowHandles());
        // Switch to new tab of Product page
        driver.switchTo().window(windows.get(1));
        // Verify 'About this item' is present in the Product page
        assertThat(amazonProductPage.aboutThisItemLabel.getText()).isEqualTo("About this item");
        softAssert.assertEquals(amazonProductPage.aboutThisItemLabel.getText(),"About this item");
        amazonResultsPage.loggingAssertionStep(logger, amazonProductPage.aboutThisItemSectionText.getText());
        // Close new tab of Product page
        driver.switchTo().window(windows.get(1)).close();
        // Switch to default tab
        driver.switchTo().window(defaultTab);

        // Assert All
        softAssert.assertAll();
    }
}
