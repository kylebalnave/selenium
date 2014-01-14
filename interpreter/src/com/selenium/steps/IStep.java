package com.selenium.steps;

import com.selenium.exceptions.StepException;
import org.openqa.selenium.WebDriver;

/**
 * Interface for all steps
 *
 * @author balnave
 */
public interface IStep {

    public Object run() throws StepException;

    public String getDescription();

    public WebDriver getDriver();

    public Object[] getArgs();

}
