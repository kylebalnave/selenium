package com.selenium.steps.selenium1;

import com.selenium.exceptions.StepException;
import com.selenium.steps.*;
import com.selenium.steps.helpers.Selectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author kyleb2
 */
public class DoubleClick extends Selenium1Step implements IStep {

    public DoubleClick(WebDriver wd, String param1, String param2) throws StepException {
        super(wd, param1, param2);
    }

    @Override
    public Object run() {
        Actions action = new Actions(wd);
        action.doubleClick(wd.findElement(Selectors.select(param1)));
        return wd;
    }

    @Override
    public String getDescription() {
        return String.format("DoubleClick element %s", param1);
    }
    
}
