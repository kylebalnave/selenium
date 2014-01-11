package com.balnave.selenium.drivers;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;

/**
 * Creates SeleniumDriver
 *
 * @author balnave
 */
public class DriverFactory {

    public WebDriver getDriver(Object... args) throws MalformedURLException {
        String type = ((String) args[0]).toLowerCase();
        String gridHubUrl = null;
        Object options = null;
        if (args.length == 2) {
            // 2nd arg is options or grid url
            if(args[1] instanceof String) {
                getRemoteDriver(type, (String) args[1]);
            } else {
                getLocalDriver(type, args[1]);
            }
        } else if (args.length == 3) {
            // 2nd arg is options
            // 3rd is grid url
            getRemoteDriver(type, args[1], (String) args[2]);
        }
        return null;
    }

    private WebDriver getLocalDriver(String type, Object options) {
        if (type.contains("firefox")) {
            return new FirefoxDriver().getDriver(options);
        } else if (type.contains("ie") || type.contains("explorer")) {
            return new InternetExplorerDriver().getDriver(options);
        } else if (type.contains("chrome")) {
            return new ChromeDriver().getDriver(options);
        } else if (type.contains("safari")) {
            return new SafariDriver().getDriver(options);
        } else if (type.contains("phantom")) {
            return new PhantomDriver().getDriver(options);
        } else if (type.contains("htmlunit")) {
            return new HtmlUnitDriver().getDriver(options);
        }
        return null;
    }
    
    private WebDriver getRemoteDriver(String type, String gridHubUrl) throws MalformedURLException {
        return getRemoteDriver(type, gridHubUrl, null);
    }

    private WebDriver getRemoteDriver(String type, Object options, String gridHubUrl) throws MalformedURLException {
        if (type.contains("firefox")) {
            return new FirefoxDriver().getRemoteDriver(gridHubUrl, options);
        } else if (type.contains("ie") || type.contains("explorer")) {
            return new InternetExplorerDriver().getRemoteDriver(gridHubUrl, options);
        } else if (type.contains("chrome")) {
            return new ChromeDriver().getRemoteDriver(gridHubUrl, options);
        } else if (type.contains("safari")) {
            return new SafariDriver().getRemoteDriver(gridHubUrl, options);
        } else if (type.contains("phantom")) {
            return new PhantomDriver().getRemoteDriver(gridHubUrl, options);
        } else if (type.contains("htmlunit")) {
            return new HtmlUnitDriver().getRemoteDriver(gridHubUrl, options);
        }
        return null;
    }
}
