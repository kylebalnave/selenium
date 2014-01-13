package com.selenium.steps;

import com.selenium.exceptions.StepException;
import com.selenium.steps.helpers.Selectors;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author kyleb2
 */
public abstract class SelectionStep extends Selenium1Step implements IStep {

    public SelectionStep(Object... args) throws StepException {
        super(args);
    }

    /**
     * Checks if an element exists
     * @param wd
     * @param selector
     * @return 
     */
    protected boolean elementExists(WebDriver wd, String selector) {
        try {
            WebElement elem = selectElement(wd, (String) getArg(1));
            return elem != null;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected WebElement selectElement(WebDriver wd, String selector) {
        return wd.findElement(Selectors.select((String) getArg(1)));
    }

}
