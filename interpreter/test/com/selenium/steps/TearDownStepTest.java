package com.selenium.steps;

import com.selenium.testing.PseudoWebDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

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
