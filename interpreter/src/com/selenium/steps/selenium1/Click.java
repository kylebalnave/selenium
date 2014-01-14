package com.selenium.steps.selenium1;

import com.selenium.exceptions.StepException;
import com.selenium.steps.*;
import com.selenium.steps.helpers.Selectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author kyleb2
 */
public class Click extends Selenium1Step implements IStep {

    public Click(WebDriver wd, String param1, String param2) throws StepException {
        super(wd, param1, param2);
    }

    @Override
    public Object run() {
        Actions action = new Actions(wd);
        action.click(wd.findElement(Selectors.select(param1)));
        return wd;
    }

    @Override
    public String getDescription() {
        return String.format("Click element %s", param1);
    }
    
}
