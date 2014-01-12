package com.selenium.drivers;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;

/**
 * Abstract SeleniumDriver
 * @author balnave
 */
public abstract class SeleniumDriver implements ISeleniumDriver {

    @Override
    public WebDriver getDriver() {
        return getDriver(null);
    }

    @Override
    public abstract WebDriver getDriver(Object options);

    @Override
    public WebDriver getRemoteDriver(String seleniumGridHubUrl) throws MalformedURLException {
        return getRemoteDriver(seleniumGridHubUrl, null);
    }

    @Override
    public abstract WebDriver getRemoteDriver(String seleniumGridHubUrl, Object options) throws MalformedURLException;
    
}
