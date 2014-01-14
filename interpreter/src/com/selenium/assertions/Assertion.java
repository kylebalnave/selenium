package com.selenium.assertions;

import com.selenium.steps.IStep;
import com.selenium.steps.Step;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;
import org.openqa.selenium.WebDriver;

/**
 * The Abstract Class
 * @author kyleb2
 */
public abstract class Assertion extends Step implements IStep, IVerify {

    public Assertion(WebDriver wd, Object... args) {
        super(wd, args);
    }
    
    @Override
    public Object run() {
        assertTrue(getDescription(), test());
        return null;
    } 

    
}
