package com.selenium.steps.selenium1;

import com.selenium.exceptions.StepException;
import com.selenium.steps.*;
import com.selenium.steps.Selenium1Step;
import org.openqa.selenium.WebDriver;

/**
 * @author kyleb2
 */
public class AddScript extends Selenium1Step implements IStep {

    protected IStep runScript;
    protected String scriptFormatToRun = "var head =  document.getElementsByTagName('head')[0];\n"
            + "var script = document.createElement('script');\n"
            + "script.type = 'text/javascript';\n"
            + "script.src = '%s';\n"
            + "head.appendChild(script);";
    

    public AddScript(WebDriver wd, String param1, String param2) throws StepException {
        super(wd, param1, param2);
        runScript = new RunScript(wd, String.format(scriptFormatToRun, param1), null);
    }

    @Override
    public Object run() throws StepException {
        return runScript.run();
    }

    @Override
    public String getDescription() {
        return String.format("Add Script %s to <head>", param1);
    }

}
