package com.selenium.steps;

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

    public ClickAndWaitStep(Object... args) {
        super(args);
    }

    @Override
    public WebDriver run(WebDriver wd) {
        WebDriverWait wait = new WebDriverWait(wd, waitSec);
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.select((String) getArg(1))));
        WebElement elem = selectElement(wd, (String) getArg(1));
        elem.click();
        return wd;
    }

    @Override

    public String toJavaString() {
        return String.format("%s\n%s\n%s\n",
                String.format("org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(wd, %s);", (String) getArg(1)),
                String.format("wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(com.selenium.steps.helpers.Selectors.select(\"%s\")));", (String) getArg(1)),
                String.format("org.openqa.selenium.WebElement elem = selectElement(wd, \"%s\");", (String) getArg(1)),
                String.format("elem.click();"));
    }

}
