package com.balnave.selenium.interpreter.ide;

import com.balnave.selenium.exceptions.InvalidSeleneseException;
import com.balnave.selenium.exceptions.ParserException;
import com.balnave.selenium.exceptions.StepException;
import com.balnave.selenium.steps.IStep;
import com.balnave.selenium.steps.StepFactory;
import com.json.parsers.JSONParser;
import com.json.parsers.JsonParserFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Selenium 2 (aka Selenium Builder) json parser
 *
 * @author balnave
 */
public class Selenium2Parser implements ISeleneseParser {

    protected final StepFactory stepFactory = new StepFactory();

    @Override
    public List<IStep> parse(String content) throws InvalidSeleneseException, ParserException {
        List<IStep> stepList = new ArrayList<IStep>();
        JsonParserFactory factory = JsonParserFactory.getInstance();
        JSONParser parser = factory.newJsonParser();
        Map jsonMap = parser.parseJson(content);
        if (jsonMap.containsKey("seleniumVersion") && jsonMap.containsKey("formatVersion")) {
            List<Map> jsonSteps = (List<Map>) jsonMap.get("steps");
            for (Map jsonStep : jsonSteps) {
                List stepParts = new ArrayList();
                stepParts.add(jsonStep.get("type"));
                stepParts.add(jsonStep.get("negated"));
                stepParts.add(jsonStep.get("locator"));
                for (Object key : jsonStep.keySet()) {
                    // add any additional values
                    if (!key.equals("type") && !key.equals("negated") && !key.equals("locator")) {
                        stepParts.add(jsonStep.get(key));
                    }
                }
                IStep iStep;
                try {
                    iStep = stepFactory.buildStep(
                            Integer.parseInt((String) jsonMap.get("seleniumVersion"), 10),
                            Integer.parseInt((String) jsonMap.get("formatVersion"), 10),
                            stepParts.toArray(new Object[6]));
                    if (iStep != null) {
                        stepList.add(iStep);
                    }
                } catch (StepException ex) {
                    throw new ParserException("Error creating Selenium2 step", ex);
                }
            }
        } else {
            throw new InvalidSeleneseException(String.format("The Selenium2Parser file seems to be invalid"));
        }
        return stepList;
    }

}
