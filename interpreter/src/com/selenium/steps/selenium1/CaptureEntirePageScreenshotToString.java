package com.selenium.steps.selenium1;

import com.selenium.exceptions.StepException;
import com.selenium.steps.*;
import com.selenium.steps.Selenium1Step;
import org.openqa.selenium.WebDriver;

/**
 * @author kyleb2
 */
public class CaptureEntirePageScreenshotToString extends Selenium1Step implements IStep {
    
    protected IStep step;

    public CaptureEntirePageScreenshotToString(WebDriver wd, String param1, String param2) throws StepException {
        super(wd, param1, param2);
        step = new CaptureScreenshotToString(wd, param1, param2);
    }

    @Override
    public Object run() throws StepException {
        return step.run();
    }

    @Override
    public String getDescription() {
        return step.getDescription();
    }
    
}
