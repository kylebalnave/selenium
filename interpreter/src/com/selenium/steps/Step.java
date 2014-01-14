package com.selenium.steps;

import org.openqa.selenium.WebDriver;

/**
 * The simplest Step
 *
 * @author kyleb2
 */
public abstract class Step implements IStep {

    protected final WebDriver wd;
    protected final Object[] args;

    public Step(WebDriver wd, Object... args) {
        this.wd = wd;
        this.args = args;
    }

    @Override
    public WebDriver getDriver() {
        return wd;
    }

    @Override
    public Object[] getArgs() {
        return args;
    }
    
}
