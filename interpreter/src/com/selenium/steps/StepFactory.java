package com.selenium.steps;

import com.selenium.exceptions.StepException;

/**
 * Creates ISteps
 *
 * @author kyleb2
 */
public class StepFactory {

    public IStep buildStep(int seleniumVersion, int formatVersion, Object... args) throws StepException {
        IStep step = null;
        if (seleniumVersion == 1) {
            step = buildSelenium1Step(args);
        } else if (seleniumVersion == 2 && formatVersion == 1) {
            step = buildSelenium2Format1Step(args);
        } else {
            throw new StepException(String.format("Cannot find any Steps for Selenium %s, format %s", seleniumVersion, formatVersion));
        }
        return step;
    }

    /**
     * Creates Selenium1Steps
     *
     * @param args
     * @return
     */
    private IStep buildSelenium1Step(Object... args) throws StepException {
        String stepName = (String) args[0];
        if (stepName.equals("open")) {
            return null;
        } else {
            throw new StepException(String.format("Cannot find Selenium 1 step with name %s", (String) args[0]));
        }
    }

    /**
     * Creates Selenium2Steps with format 1
     *
     * @param args
     * @return
     */
    private IStep buildSelenium2Format1Step(Object... args) throws StepException {
        throw new StepException(String.format("Cannot find Selenium 2 format 1 step with name %s", (String) args[0]));
    }

}
