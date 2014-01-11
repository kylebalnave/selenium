package com.balnave.selenium.drivers;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Implementation of ISeleniumDriver
 *
 * @author balnave
 */
public class InternetExplorerDriver extends SeleniumDriver implements ISeleniumDriver {

    @Override
    public WebDriver getDriver(Object options) {
        if (options instanceof InternetExplorerDriverService) {
            return new org.openqa.selenium.ie.InternetExplorerDriver((InternetExplorerDriverService) options);
        }
        return new org.openqa.selenium.ie.InternetExplorerDriver();
    }

    @Override
    public WebDriver getRemoteDriver(String seleniumGridHubUrl, Object options) throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
        if(options instanceof String && ((String)options).matches("^ie\\d+$")) {
            dc.setVersion((String) options);
        }
        return new RemoteWebDriver(new URL(seleniumGridHubUrl), dc);
    }

}
