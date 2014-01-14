package com.selenium.steps.selenium1;

import com.selenium.exceptions.StepException;
import com.selenium.steps.*;
import org.openqa.selenium.WebDriver;

/**
 * @author kyleb2
 */
public class GetAttribute extends Selenium1Step implements IStep {

    public GetAttribute(WebDriver wd, String param1, String param2) throws StepException {
        super(wd, param1, param2);
    }

    @Override
    public Object run() {
        return wd;
    }

    @Override
    public String getDescription() {
        return String.format("Unsupported Step %s", getClass().getName());
    }
    
}
