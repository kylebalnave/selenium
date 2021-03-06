package com.selenium.steps.selenium1;

import com.selenium.exceptions.StepException;
import com.selenium.steps.*;
import com.selenium.steps.Selenium1Step;
import org.openqa.selenium.WebDriver;

/**
 * @author kyleb2
 */
public class GetCookieByName extends Selenium1Step implements IStep {

    public GetCookieByName(WebDriver wd, String param1, String param2) throws StepException {
        super(wd, param1, param2);
    }

    @Override
    public Object run() {
        return wd.manage().getCookieNamed(param1);
    }

    @Override
    public String getDescription() {
        return String.format("Getting cookie %s", param1);
    }
    
}
