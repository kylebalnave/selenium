package com.selenium.steps.selenium1;

import com.selenium.exceptions.StepException;
import com.selenium.steps.*;
import com.selenium.steps.Selenium1Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

/**
 * @author kyleb2
 */
public class CaptureScreenshotToString extends Selenium1Step implements IStep {

    public CaptureScreenshotToString(WebDriver wd, String param1, String param2) throws StepException {
        super(wd, param1, param2);
    }

    @Override
    public Object run() {
        WebDriver augmentedDriver = new Augmenter().augment(wd);
        return ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.BASE64);
    }

    @Override
    public String getDescription() {
        return String.format("Take screenshot to String");
    }
    
}
