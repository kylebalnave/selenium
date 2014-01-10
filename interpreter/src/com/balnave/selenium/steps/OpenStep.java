package com.balnave.selenium.steps;

import com.balnave.selenium.steps.IStep;
import org.openqa.selenium.WebDriver;

/**
 * Opens a URL
 * @author kyleb2
 */
public class OpenStep extends Step implements IStep {

    public OpenStep(Object[] args) {
        super(args);
    }

    @Override
    public void run(WebDriver wd) {
        wd.get((String) getArg(1, null));
    }

    @Override
    public String toJavaString() {
        return String.format("wd.get(\"&s\");", getArg(1, null));
    }
    
}
