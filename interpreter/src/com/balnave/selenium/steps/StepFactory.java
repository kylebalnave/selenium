package com.balnave.selenium.steps;

/**
 * Creates ISteps
 * @author kyleb2
 */
public class StepFactory {

    public IStep buildStep(int seleniumVersion, int formatVersion, Object... args) {
        IStep step = null;
        if (seleniumVersion == 1) {
            step = buildSelenium1Step(args);
        } else if (seleniumVersion == 2 && formatVersion == 1) {
            step = buildSelenium2Format1Step(args);
        } else if (seleniumVersion == 2 && formatVersion == 2) {
            step = buildSelenium2Format2Step(args);
        }
        return step;
    }

    private IStep buildSelenium1Step(Object... args) {
        String stepName = (String) args[0];
        if (stepName.equals("open")) {
            return new OpenStep(args);
        }
        return null;
    }

    private IStep buildSelenium2Format1Step(Object... args) {
        return null;
    }
    
    private IStep buildSelenium2Format2Step(Object... args) {
        return null;
    }

}
