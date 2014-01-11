package com.balnave.selenium.interpreter.ide;

import com.balnave.selenium.exceptions.InvalidSeleneseException;
import com.balnave.selenium.exceptions.ParserException;
import com.balnave.selenium.exceptions.StepException;
import com.balnave.selenium.steps.IStep;
import com.balnave.selenium.steps.StepFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Selenium 1 (aka Selenium IDE) HTML parser Expects an HTML file Each step is
 * held within a table Each step has a "name", "param1" and optional "param2"
 *
 * @author balnave
 */
public class Selenium1Parser implements ISeleneseParser {

    protected final StepFactory factory = new StepFactory();
    protected final Pattern tbodyPattern = Pattern.compile("<tbody>(.*?)<\\/tbody>", Pattern.DOTALL);
    protected final Pattern trPattern = Pattern.compile("<tr>(.*?)<\\/tr>", Pattern.DOTALL);
    protected final Pattern tdPattern = Pattern.compile("<td>(.*?)<\\/td>", Pattern.DOTALL);

    @Override
    public List<IStep> parse(String content) throws InvalidSeleneseException, ParserException {
        List<IStep> stepList = new ArrayList<IStep>();
        if (!content.contains("http://selenium-ide.openqa.org/profiles/test-case")) {
            throw new InvalidSeleneseException(String.format("The Selenium1Parser file seems to be invalid"));
        }
        //
        // find the <tbody> 
        List<String> stepGroups = matchAll(tbodyPattern, content);
        if (stepGroups.size() != 1) {
            throw new InvalidSeleneseException(String.format("The Selenium1Parser file should only have 1 table of steps"));
        }
        for (String group : stepGroups) {
            //
            // find each <tr>
            List<String> steps = matchAll(trPattern, group);
            for (String step : steps) {
                //
                // find each <td>
                List<String> stepParts = matchAll(tdPattern, step);
                //
                // valid steps should have 3 parts
                if (stepParts.size() == 3) {
                    IStep iStep;
                    try {
                        iStep = factory.buildStep(1, 1, stepParts.toArray(new Object[3]));
                        if (iStep != null) {
                            stepList.add(iStep);
                        }
                    } catch (StepException ex) {
                        throw new ParserException("Error creating Selenium1 step", ex);
                    }
                } else {
                    throw new InvalidSeleneseException(String.format("Each Selenese 1 step should have no more than 3 variables, but found %s", stepParts.size()));
                }
            }
        }
        return stepList;
    }

    /**
     * Matches all RegExp and returns a list
     *
     * @param pattern
     * @param content
     * @return
     */
    protected List<String> matchAll(Pattern pattern, String content) {
        List<String> result = new ArrayList<String>();
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            result.add(matcher.group(1));
        }
        return result;
    }

}
