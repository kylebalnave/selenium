package com.selenium.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author balnave
 */
public class WaitStep extends StepDecorator implements IStep {
    
    protected final ExpectedCondition condition;
    protected final int timeoutSec;
    
    public WaitStep(IStep step, ExpectedCondition condition) {
        this(step, condition, 10);
    }

    public WaitStep(IStep step, ExpectedCondition condition, int timeoutSec) {
        super(step);
        this.condition = condition;
        this.timeoutSec = timeoutSec;
    }
    

    @Override
    public Object run() {
        new WebDriverWait(step.getDriver(), timeoutSec).until(condition);
        return null;
    }

    @Override
    public String getDescription() {
        return String.format("Waiting for condition.");
    }

    @Override
    public WebDriver getDriver() {
        return step.getDriver();
    }

    @Override
    public Object[] getArgs() {
        return step.getArgs();
    }
    
}
