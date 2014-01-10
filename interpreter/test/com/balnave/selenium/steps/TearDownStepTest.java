package com.balnave.selenium.steps;

import com.balnave.selenium.testing.PseudoWebDriver;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 *
 * @author balnave
 */
public class TearDownStepTest {

    public TearDownStepTest() {
    }

    @Test
    public void testRun() {
        System.out.println("run");
        WebDriver wd = new PseudoWebDriver();
        try {
            TearDownStep instance = new TearDownStep();
            wd = instance.run(wd);
            assertEquals(wd, null);
        } catch (UnsupportedOperationException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void testToJavaString() {
        System.out.println("toJavaString");
        SetupStep instance = new SetupStep();
        String result = instance.toJavaString();
        assertTrue(!result.isEmpty());
    }

}
