package com.balnave.selenium.drivers;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Implementation of ISeleniumDriver
 *
 * @author balnave
 */
public class FirefoxDriver extends SeleniumDriver implements ISeleniumDriver {


    @Override
    public WebDriver getDriver(Object options) {
        return new org.openqa.selenium.firefox.FirefoxDriver();
    }

    @Override
    public WebDriver getRemoteDriver(String seleniumGridHubUrl, Object options) throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        return new RemoteWebDriver(new URL(seleniumGridHubUrl), dc);
    }

}
