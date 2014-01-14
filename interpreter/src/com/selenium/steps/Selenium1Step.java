package com.selenium.steps;

import com.selenium.exceptions.StepException;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author kyleb2
 */
public abstract class Selenium1Step extends Step implements IStep {
    
    protected String param1;
    protected String param2;
    
    public Selenium1Step(WebDriver wd, String param1) throws StepException {
        super(wd, param1, null);
    }

    public Selenium1Step(WebDriver wd, String param1, String param2) throws StepException {
        super(wd);
        this.param1 = param1;
        this.param2 = param2;
    }
}
