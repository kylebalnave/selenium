package com.selenium.steps;

import org.openqa.selenium.WebDriver;

/**
 * Interface for all steps
 *
 * @author balnave
 */
public interface IStep {

    public Object run();

    public String getDescription();

    public WebDriver getDriver();

    public Object[] getArgs();

}
