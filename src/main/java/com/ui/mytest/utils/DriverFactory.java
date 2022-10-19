package com.ui.mytest.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;
import java.util.Map;


/**
 * This class has method to create WebDriver
 *
 * @author Vishwas
 */
public class DriverFactory {

    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();

    public static WebDriver getWebDriver() {
        return threadLocalDriver.get();
    }

    public static void createWebDriver(String browser) {
        WebDriver driver;

        switch (browser) {
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxProfile profile = new FirefoxProfile();
                profile.setAcceptUntrustedCertificates(true);
                profile.setAssumeUntrustedCertificateIssuer(false);
                profile.setPreference("pageLoadStrategy", "normal");
                profile.setPreference("browser.download.folderList", 2);
                profile.setPreference("browser.download.dir", TestUtils.downloadPath);
                profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                        "text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel");  // MIME types
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability(FirefoxDriver.PROFILE, profile);
                firefoxOptions.addArguments("--disable-web-security");
                firefoxOptions.addArguments("--allow-running-insecure-content");
                driver = new FirefoxDriver(firefoxOptions);

            case "Edge":
                WebDriverManager.edgedriver().setup();
                Map<String, Object> edgePrefs = new HashMap<String, Object>();
                edgePrefs.put("profile.default_content_settings.popups", 0);
                edgePrefs.put("download.default_directory", TestUtils.downloadPath);
                edgePrefs.put("download.prompt_for_download", false);
                EdgeOptions options = new EdgeOptions();
                options.setCapability("InPrivate", true);
                options.setCapability("prefs", edgePrefs);
                driver = new EdgeDriver(options);

            default:
                WebDriverManager.chromedriver().setup();
                HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("profile.default_content_settings.popups", 0);
                chromePrefs.put("download.default_directory", TestUtils.downloadPath);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("prefs", chromePrefs);
                chromeOptions.addArguments("--incognito");
                driver = new ChromeDriver(chromeOptions);
        }
        threadLocalDriver.set(driver);
    }
}
