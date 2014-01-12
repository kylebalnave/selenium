package com.selenium.drivers;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Implementation of ISeleniumDriver
 *
 * @author balnave
 */
public class PhantomDriver extends SeleniumDriver implements ISeleniumDriver {

    @Override
    public WebDriver getDriver(Object options) {
        return new PhantomJSDriver();
    }

    @Override
    public WebDriver getRemoteDriver(String seleniumGridHubUrl, Object options) throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.phantomjs();
        return new RemoteWebDriver(new URL(seleniumGridHubUrl), dc);
    }

}
