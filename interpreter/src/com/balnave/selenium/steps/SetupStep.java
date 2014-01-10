
package com.balnave.selenium.steps;

import com.balnave.selenium.testing.PseudoWebDriver;
import org.openqa.selenium.WebDriver;

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
            wd = new PseudoWebDriver();
        }
        return wd;
    }

    @Override
    public String toJavaString() {
        return String.format("org.openqa.selenium.WebDriver wd = new FirefoxDriver();");
    }
    
}
