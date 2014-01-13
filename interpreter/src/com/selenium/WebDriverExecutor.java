package com.selenium;

import com.selenium.steps.IStep;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * A WebDriver executor plays a list of Steps and Assertions
 * @author balnave
 */
public final class WebDriverExecutor {
    
    protected WebDriver wd;
    protected List<IStep> steps;
    
    public WebDriverExecutor(WebDriver wd, List<IStep> steps) {
        this.wd = wd;
        this.steps = steps;
        setup();
        for (IStep step : steps) {
            doForEachStep(step);
        }
        teardown();
    }
        
    public void setup() {
        wd = wd == null ? new HtmlUnitDriver(true) : wd;
    }

    public void teardown() {
        if(wd != null) {
            wd.quit();
            wd = null;
        }
    }

    public void doForEachStep(IStep step) {
        step.run();
    }   
    
    
}
