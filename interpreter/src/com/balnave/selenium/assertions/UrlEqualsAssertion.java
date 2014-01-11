package com.balnave.selenium.assertions;

import static junit.framework.TestCase.assertEquals;
import org.openqa.selenium.WebDriver;

/**
 * Asserts the WebDriver url
 * @author balnave
 */
public class UrlEqualsAssertion extends Assertion {

    public UrlEqualsAssertion(Object valueToAssert) {
        super(valueToAssert);
    }

    @Override
    public WebDriver run(WebDriver wd) {
        assertEquals(valueToAssert, wd.getCurrentUrl());
        return wd;
    }

    @Override
    public String toJavaString() {
        return String.format("junit.framework.TestCase.assertEquals(wd.getCurrentUrl(), \"%s\";", getArg(1, null));
    }
    
}
