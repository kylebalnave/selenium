package com.selenium.steps;

import com.selenium.exceptions.StepException;
import com.selenium.steps.helpers.Selectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Types some Text into a field
 *
 * @author kyleb2
 */
public class ClickAndWaitStep extends SelectionStep implements IStep {

    protected int waitSec = 10;

    public ClickAndWaitStep(Object... args) throws StepException {
        super(args);
    }

    @Override
    public WebDriver run(WebDriver wd) {
        WebDriverWait wait = new WebDriverWait(wd, waitSec);
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.select(param1)));
        WebElement elem = selectElement(wd, param1);
        elem.click();
        return wd;
    }

    @Override

    public String getDescription() {
        return String.format("Wait for element %s to be available, then click.", param1);
    }

}
