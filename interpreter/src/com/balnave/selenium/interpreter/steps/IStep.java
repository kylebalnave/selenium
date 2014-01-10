package com.balnave.selenium.interpreter.steps;

import org.openqa.selenium.WebDriver;

/**
 * Interface for all steps
 * @author balnave
 */
public interface IStep {
    
    public void run(WebDriver wd);
    
    public String toJavaString();
    
}
