package com.selenium.steps.selenium1;

import com.selenium.steps.IStep;
import com.selenium.steps.Step;
import org.openqa.selenium.WebDriver;

/**
 * @author kyleb2
 */
public class AddLocationStrategy extends Step implements IStep {

    
    public AddLocationStrategy(WebDriver wd, Object... args) {
        super(wd, args);
    }


    @Override
    public Object run() {
        return wd;
    }

    @Override
    public String getDescription() {
        return String.format("@TODO add description");
    }
    
}
