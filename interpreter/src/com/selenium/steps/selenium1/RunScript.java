package com.selenium.steps.selenium1;

import com.selenium.exceptions.StepException;
import com.selenium.steps.*;
import com.selenium.steps.Selenium1Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * @author kyleb2
 */
public class RunScript extends Selenium1Step implements IStep {
    
    public RunScript(WebDriver wd, String param1) throws StepException {
        super(wd, param1, null);
    }

    public RunScript(WebDriver wd, String param1, String param2) throws StepException {
        super(wd, param1, param2);
    }

    @Override
    public Object run() throws StepException {
        if (wd instanceof JavascriptExecutor) {
            JavascriptExecutor js = (JavascriptExecutor) wd;
            return js.executeScript(param1);
        } else {
            throw new StepException(String.format("Cannot RunScript because the WebDriver is not an instanceof JavascriptExecutor!"));
        }
    }

    @Override
    public String getDescription() {
        return String.format("Execute inline Script");
    }

}
