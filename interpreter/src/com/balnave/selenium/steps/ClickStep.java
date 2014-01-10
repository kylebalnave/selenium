package com.balnave.selenium.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Types some Text into a field
 * @author kyleb2
 */
public class ClickStep extends SelectionStep implements IStep {

    public ClickStep(Object... args) {
        super(args);
    }

    @Override
    public WebDriver run(WebDriver wd) {
        WebElement elem = selectElement(wd, (String) getArg(1));
        elem.click();
        return wd;
    }

    @Override
    public String toJavaString() {
        return String.format("%s\n%s\n", 
                String.format("org.openqa.selenium.WebElement elem = selectElement(wd, \"%s\");", (String) getArg(1)),
                String.format("elem.click();"));
    }
    
}
