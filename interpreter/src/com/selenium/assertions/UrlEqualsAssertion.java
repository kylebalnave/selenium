package com.selenium.assertions;

import static com.thoughtworks.selenium.SeleneseTestCase.assertEquals;
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
    public String getDescription() {
        return String.format("Assert url %s equals current WebDriver url.", getArg(1, null));
    }
    
}
