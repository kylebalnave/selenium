package com.balnave.selenium.steps;

import org.openqa.selenium.WebDriver;

/**
 * Interface for all steps
 * @author balnave
 */
public interface IStep {
    
    public WebDriver run(WebDriver wd);
    
    public String toJavaString();
    
}
