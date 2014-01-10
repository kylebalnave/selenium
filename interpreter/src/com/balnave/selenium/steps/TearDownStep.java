
package com.balnave.selenium.steps;

import org.openqa.selenium.WebDriver;

/**
 * TearDown a Webdriver
 * @author kyleb2
 */
public class TearDownStep extends Step implements IStep{

    public TearDownStep(Object[] args) {
        super(args);
    }

    @Override
    public void run(WebDriver wd) {
        if(wd != null) {
            wd.quit();
        }
    }

    @Override
    public String toJavaString() {
        return String.format("if(wd != null) { wd.quit; }");
    }
    
}
