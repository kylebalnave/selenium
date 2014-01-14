package com.selenium.steps.selenium1;

import com.selenium.exceptions.StepException;
import com.selenium.steps.*;
import com.selenium.steps.Selenium1Step;
import java.util.Set;
import org.openqa.selenium.WebDriver;

/**
 * @author kyleb2
 */
public class OpenWindow extends Selenium1Step implements IStep {

    public OpenWindow(WebDriver wd, String param1, String param2) throws StepException {
        super(wd, param1, param2);
    }

    @Override
    public Object run() throws StepException {
        IStep runScript = new RunScript(wd, "window.open();");
        runScript.run();
        Set<String> wHandles = wd.getWindowHandles();
        String[] handles = wHandles.toArray(new String[wHandles.size()]);
        wd.switchTo().window(handles[handles.length - 1]);
        wd.navigate().to(param1);
        return null;
    }

    @Override
    public String getDescription() {
        return String.format("Load url %s in new window", param1);
    }
    
}
