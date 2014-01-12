package com.selenium.steps;

import org.openqa.selenium.WebDriver;

/**
 * Opens a URL
 * @author kyleb2
 */
public class OpenStep extends Step implements IStep {

    public OpenStep(Object... args) {
        super(args);
    }

    @Override
    public WebDriver run(WebDriver wd) {
        wd.get((String) getArg(1, null));
        return wd;
    }

    @Override
    public String toJavaString() {
        return String.format("wd.get(\"%s\n\");", getArg(1, null));
    }
    
}
