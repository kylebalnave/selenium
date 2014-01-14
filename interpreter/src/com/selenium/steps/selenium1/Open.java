package com.selenium.steps.selenium1;

import com.selenium.exceptions.StepException;
import com.selenium.steps.*;
import com.selenium.steps.Selenium1Step;
import org.openqa.selenium.WebDriver;

/**
 * @author kyleb2
 */
public class Open extends Selenium1Step implements IStep {

    public Open(WebDriver wd, String param1, String param2) throws StepException {
        super(wd, param1, param2);
    }

    @Override
    public Object run() {
        wd.get(param1);
        return null;
    }

    @Override
    public String getDescription() {
        return String.format("Load url %s", param1);
    }
    
}
