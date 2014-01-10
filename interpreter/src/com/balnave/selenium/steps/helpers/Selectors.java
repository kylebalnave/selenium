package com.balnave.selenium.steps.helpers;

import org.openqa.selenium.By;

/**
 * Utility methods to help with selection
 *
 * @author kyleb2
 */
public class Selectors {

    public static By select(String selector) {
        By bySelector = null;
        if (isClassNameSelector(selector)) {
            bySelector = By.className(selector);
        } else if (isCssSelector(selector)) {
            bySelector = By.cssSelector(selector);
        } else if (isIdSelector(selector)) {
            bySelector = By.id(selector.replace("id=", ""));
        } else if (isLinkTextSelector(selector)) {
            bySelector = By.partialLinkText(selector.replace("link=", ""));
        } else if (isTagNameSelector(selector)) {
            bySelector = By.tagName(selector);
        } else if (isXPathSelector(selector)) {
            bySelector = By.xpath(selector);
        }
        return bySelector;
    }

    private static boolean isClassNameSelector(String selector) {
        return false;
    }

    private static boolean isCssSelector(String selector) {
        return false;
    }

    private static boolean isIdSelector(String selector) {
        return selector.startsWith("id=");
    }

    private static boolean isLinkTextSelector(String selector) {
        return selector.startsWith("link=");
    }

    private static boolean isTagNameSelector(String selector) {
        return false;
    }

    private static boolean isXPathSelector(String selector) {
        return false;
    }
}
