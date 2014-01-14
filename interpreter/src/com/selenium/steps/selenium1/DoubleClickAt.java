package com.selenium.steps.selenium1;

import com.selenium.exceptions.StepException;
import com.selenium.steps.*;
import com.selenium.steps.helpers.Selectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author kyleb2
 */
public class DoubleClickAt extends Selenium1Step implements IStep {

    public DoubleClickAt(WebDriver wd, String param1, String param2) throws StepException {
        super(wd, param1, param2);
    }

    @Override
    public Object run() {
        int offsetX = Integer.valueOf(param2.split(",")[0]);
        int offsetY = Integer.valueOf(param2.split(",")[1]);
        Actions action = new Actions(wd);
        action.moveToElement(wd.findElement(Selectors.select(param1))).
               moveByOffset(offsetX, offsetY).doubleClick();
        return null;
    }

    @Override
    public String getDescription() {
        return String.format("DoubleClick %s with offset", param1, param2);
    }
    
}
