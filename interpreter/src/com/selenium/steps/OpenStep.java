package com.selenium.steps;

import com.selenium.exceptions.StepException;
import org.openqa.selenium.WebDriver;

/**
 * Opens a URL
 * @author kyleb2
 */
public class OpenStep extends Selenium1Step implements IStep {

    public OpenStep(Object... args) throws StepException {
        super(args);
    }

    @Override
    public WebDriver run(WebDriver wd) {
        wd.get((String) param1);
        return wd;
    }

    @Override
    public String getDescription() {
        return String.format("Open url %s.", param1);
    }
    
}
