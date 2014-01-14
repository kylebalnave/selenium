package com.selenium.steps.selenium1;

import com.selenium.exceptions.StepException;
import com.selenium.steps.*;
import com.selenium.steps.Selenium1Step;
import com.selenium.steps.helpers.Selectors;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author kyleb2
 */
public class AssignId extends Selenium1Step implements IStep {

    public AssignId(WebDriver wd, String param1, String param2) throws StepException {
        super(wd, param1, param2);
    }

    @Override
    public Object run() {
        List<WebElement> matchedElements = wd.findElements(Selectors.select(param1));
        for(WebElement element : matchedElements) {
            String script = String.format("return arguments[0].target = '%s';", param2);
            String contents = (String)((JavascriptExecutor)wd).executeScript(script, element);
        }
        return null;
    }

    @Override
    public String getDescription() {
        return String.format("Assign id %s to locator %s", param2, param1);
    }
    
}
