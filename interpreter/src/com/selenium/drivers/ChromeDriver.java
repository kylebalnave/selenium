package com.selenium.drivers;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Implementation of ISeleniumDriver for Chrome
 *
 * @author balnave
 */
public class ChromeDriver extends SeleniumDriver implements ISeleniumDriver {

    @Override
    public WebDriver getDriver(Object options) {
        if (options instanceof ChromeOptions) {
            return new org.openqa.selenium.chrome.ChromeDriver((ChromeOptions) options);
        }
        return new org.openqa.selenium.chrome.ChromeDriver();
    }

    @Override
    public WebDriver getRemoteDriver(String seleniumGridHubUrl, Object options) throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        if (options instanceof ChromeOptions) {
            dc.setCapability(ChromeOptions.CAPABILITY, options);
        }
        return new RemoteWebDriver(new URL(seleniumGridHubUrl), dc);
    }

}
