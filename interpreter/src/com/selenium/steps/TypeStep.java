package com.selenium.steps;

import com.selenium.exceptions.StepException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Types some Text into a field
 * @author kyleb2
 */
public class TypeStep extends SelectionStep implements IStep {

    public TypeStep(Object... args) throws StepException {
        super(args);
    }

    @Override
    public WebDriver run(WebDriver wd) {
        WebElement elem = selectElement(wd, param1);
        elem.sendKeys(param2);
        return wd;
    }

    @Override
    public String getDescription() {
        return String.format("Select element %s, then type %s.", param1, param2);
    }
    
}
