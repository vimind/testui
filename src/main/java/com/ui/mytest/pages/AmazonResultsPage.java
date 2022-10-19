package com.ui.mytest.pages;

import com.ui.mytest.utils.PageElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page class of Home page
 *
 * @author Vishwas
 */
public class AmazonResultsPage extends BasePage {
    // Locators
    public static final By SORT_BY_DROPDOWN = By.id("s-result-sort-select");
    public static final String TV_BRAND_CHECKBOX = "//span[text()='%s']/preceding-sibling::div//i";
    public static final String SEARCH_RESULT_ITEM = "[cel_widget_id='MAIN-SEARCH_RESULTS-%d'] a";
    // Elements
    public PageElement sortByDropdown;

    public AmazonResultsPage(WebDriver driver) {
        super(driver);
        sortByDropdown = new PageElement(driver, SORT_BY_DROPDOWN);
    }

    /**
     * Click on TV brand
     *
     * @param brand of a TV to be filtered
     */
    @Step("Select checkbox '{0}' under brands to filter the result")
    public void selectTVBrand(String brand) {
        PageElement brandCheckbox = new PageElement(driver, By.xpath(String.format(TV_BRAND_CHECKBOX, brand)));
        brandCheckbox.scrollIntoView();
        brandCheckbox.waitUntilElementToBeClickable();
        brandCheckbox.click();
    }

    /**
     * Sort by given option
     *
     * @param option as per which the search items are sorted
     */
    @Step("Sort by '{0}'")
    public void selectSortByOption(String option) {
        sortByDropdown.selectByVisibleText(option);
    }

    /**
     * Click on Searched Item
     *
     * @param itemNum item number to be opened
     */
    @Step("Open on product number {0} from the search results")
    public void clickOnSearchItem(int itemNum) {
        PageElement searchItem = new PageElement(driver, By.cssSelector(String.format(SEARCH_RESULT_ITEM, itemNum)));
        searchItem.click();
    }
}
