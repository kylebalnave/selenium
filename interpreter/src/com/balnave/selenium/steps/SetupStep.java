
package com.balnave.selenium.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Setup a Webdriver
 * @author kyleb2
 */
public class SetupStep extends Step implements IStep{

    public SetupStep(Object... args) {
        super(args);
    }

    @Override
    public WebDriver run(WebDriver wd) {
        if(wd == null) {
            wd = new HtmlUnitDriver(true);
        }
        return wd;
    }

    @Override
    public String toJavaString() {
        return String.format("org.openqa.selenium.WebDriver wd = new FirefoxDriver();");
    }
    
}
