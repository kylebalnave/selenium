package com.selenium.steps.selenium1;

import com.selenium.steps.*;
import com.selenium.exceptions.StepException;
import org.openqa.selenium.WebDriver;

/**
 * @author kyleb2
 */
public class KeyUp extends Step implements IStep {

    public KeyUp(Object... args) throws StepException {
        super(args);
    }

    @Override
    public WebDriver run(WebDriver wd) {
        return wd;
    }

    @Override
    public String getDescription() {
        return String.format("@TODO add description");
    }
    
}
