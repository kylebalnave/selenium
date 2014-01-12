package com.selenium.drivers;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

/**
 * Implementation of ISeleniumDriver for Safari
 *
 * @author balnave
 */
public class SafariDriver extends SeleniumDriver implements ISeleniumDriver {

    @Override
    public WebDriver getDriver(Object options) {
        if (options instanceof SafariOptions) {
            return new org.openqa.selenium.safari.SafariDriver((SafariOptions) options);
        }
        return new org.openqa.selenium.safari.SafariDriver();
    }

    @Override
    public WebDriver getRemoteDriver(String seleniumGridHubUrl, Object options) throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        if (options instanceof SafariOptions) {
            dc.setCapability(SafariOptions.CAPABILITY, options);
        }
        return new RemoteWebDriver(new URL(seleniumGridHubUrl), dc);
    }

}
