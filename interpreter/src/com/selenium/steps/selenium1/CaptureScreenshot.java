package com.selenium.steps.selenium1;

import com.selenium.exceptions.StepException;
import com.selenium.steps.*;
import com.selenium.steps.Selenium1Step;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

/**
 * @author kyleb2
 */
public class CaptureScreenshot extends Selenium1Step implements IStep {

    public CaptureScreenshot(WebDriver wd, String param1, String param2) throws StepException {
        super(wd, param1, param2);
    }

    @Override
    public Object run() {
        WebDriver augmentedDriver = new Augmenter().augment(wd);
        File fOut = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
        return fOut.renameTo(new File(param1));
    }

    @Override
    public String getDescription() {
        return String.format("Take screenshot to File %s", param1);
    }
    
}
