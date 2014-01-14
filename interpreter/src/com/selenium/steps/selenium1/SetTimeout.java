package com.selenium.steps.selenium1;

import com.selenium.exceptions.StepException;
import com.selenium.steps.*;
import com.selenium.steps.Selenium1Step;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;

/**
 * @author kyleb2
 */
public class SetTimeout extends Selenium1Step implements IStep {

    public SetTimeout(WebDriver wd, String param1, String param2) throws StepException {
        super(wd, param1, param2);
    }

    @Override
    public Object run() {
        Timeouts to = wd.manage().timeouts();
        to.implicitlyWait(Integer.valueOf(param1), TimeUnit.SECONDS);
        to.pageLoadTimeout(Integer.valueOf(param1), TimeUnit.SECONDS);
        to.setScriptTimeout(Integer.valueOf(param1), TimeUnit.SECONDS);
        return null;
    }

    @Override
    public String getDescription() {
        return String.format("Delete cookie named %s", param1);
    }
    
}
