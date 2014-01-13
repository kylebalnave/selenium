package com.selenium.steps.selenium1;

import com.selenium.exceptions.StepException;
import com.selenium.steps.IStep;
import com.selenium.steps.Step;
import org.openqa.selenium.WebDriver;

/**
 * @author kyleb2
 */
public class UseXPathLibrary extends Step implements IStep {

    public UseXPathLibrary(WebDriver wd, Object... args) throws StepException {
        super(wd, args);
    }

    @Override
    public Object run() {
        return wd;
    }

    @Override
    public String getDescription() {
        return String.format("@TODO add description");
    }
    
}
