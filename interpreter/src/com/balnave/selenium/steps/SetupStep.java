
package com.balnave.selenium.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Setup a Webdriver
 * @author kyleb2
 */
public class SetupStep extends Step implements IStep{

    public SetupStep(Object[] args) {
        super(args);
    }

    @Override
    public void run(WebDriver wd) {
        if(wd == null) {
            wd = new FirefoxDriver();
        }
    }

    @Override
    public String toJavaString() {
        return String.format("org.openqa.selenium.WebDriver wd = new FirefoxDriver();");
    }
    
}
