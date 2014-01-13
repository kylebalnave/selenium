package com.selenium.assertions;

import org.openqa.selenium.WebDriver;

/**
 * Asserts the WebDriver url
 * @author balnave
 */
public class UrlEqualsAssertion extends Assertion {

    public UrlEqualsAssertion(WebDriver wd, Object... args) {
        super(wd, args);
    }

    @Override
    public String getDescription() {
        return String.format("Comparing url %s to the current WebDriver url %s", args[0], wd.getCurrentUrl());
    }

    @Override
    public boolean test() {
        return wd.getCurrentUrl().equals(args[0]);
    }

    
}
