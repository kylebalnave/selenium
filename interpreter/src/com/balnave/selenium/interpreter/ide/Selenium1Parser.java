package com.balnave.selenium.interpreter.ide;

import com.balnave.selenium.steps.IStep;
import com.balnave.selenium.steps.StepFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Selenium 1 (aka Selenium IDE) HTML parser
 *
 * @author balnave
 */
public class Selenium1Parser implements ISeleneseParser {

    protected final StepFactory factory = new StepFactory();
    protected final Pattern tbodyPattern = Pattern.compile("<tbody>(.*?)<\\/tbody>", Pattern.DOTALL);
    protected final Pattern trPattern = Pattern.compile("<tr>(.*?)<\\/tr>", Pattern.DOTALL);
    protected final Pattern tdPattern = Pattern.compile("<td>(.*?)<\\/td>", Pattern.DOTALL);

    @Override
    public List<IStep> parse(String content) {
        List<IStep> stepList = new ArrayList<IStep>();
        //
        // find the body 
        StringBuilder sb;
        Matcher matcher;
        List<String> stepGroups = matchAll(tbodyPattern, content);
        for (String group : stepGroups) {
            List<String> steps = matchAll(trPattern, group);
            for (String step : steps) {
                List<String> stepParts = matchAll(tdPattern, step);
                //
                // valid steps should have 3 parts
                if (stepParts.size() == 3) {
                    IStep iStep = factory.buildStep(1, 1, stepParts.toArray(new Object[3]));
                    if (iStep != null) {
                        stepList.add(iStep);
                    }
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
