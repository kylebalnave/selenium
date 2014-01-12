package com.selenium.drivers;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;

/**
 * Interface
 * @author balnave
 */
public interface ISeleniumDriver {
    
    public WebDriver getDriver();
    
    public WebDriver getDriver(Object options);
    
    public WebDriver getRemoteDriver(String seleniumGridHubUrl) throws MalformedURLException;
    
    public WebDriver getRemoteDriver(String seleniumGridHubUrl, Object options) throws MalformedURLException;
    
}
