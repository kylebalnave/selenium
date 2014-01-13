package com.selenium.steps;

import com.selenium.exceptions.StepException;
import org.openqa.selenium.WebDriver;

/**
 * Types some Text into a field
 * @author kyleb2
 */
public class ClickStep extends SelectionStep implements IStep {

    public ClickStep(Object... args) throws StepException {
        super(args);
    }

    @Override
    public WebDriver run(WebDriver wd) {
        selectElement(wd, param1).click();
        return wd;
    }

    @Override
    public String getDescription() {
        return String.format("Click element %s.", param1);
    }
    
}
