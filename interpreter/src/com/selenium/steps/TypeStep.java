package com.selenium.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Types some Text into a field
 * @author kyleb2
 */
public class TypeStep extends SelectionStep implements IStep {

    public TypeStep(Object... args) {
        super(args);
    }

    @Override
    public WebDriver run(WebDriver wd) {
        WebElement elem = selectElement(wd, (String) getArg(1));
        elem.sendKeys((CharSequence[]) getArg(2));
        return wd;
    }

    @Override
    public String toJavaString() {
        return String.format("%s\n%s\n", 
                String.format("org.openqa.selenium.WebElement elem = selectElement(wd, \"%s\");", (String) getArg(1)),
                String.format("elem.sendKeys((CharSequence[]) \"%s\");", (String) getArg(2)));
    }
    
}
