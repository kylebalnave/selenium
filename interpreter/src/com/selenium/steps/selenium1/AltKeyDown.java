package com.selenium.steps.selenium1;

import com.selenium.exceptions.StepException;
import com.selenium.steps.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author kyleb2
 */
public class AltKeyDown extends Selenium1Step implements IStep {

    public AltKeyDown(WebDriver wd, String param1, String param2) throws StepException {
        super(wd, param1, param2);
    }

    @Override
    public Object run() {
        Actions action =new Actions(wd);
        return action.keyDown(Keys.ALT);
    }

    @Override
    public String getDescription() {
        return String.format("Send Alt Key Down");
    }
    
}
