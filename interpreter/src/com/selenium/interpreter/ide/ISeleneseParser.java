package com.selenium.interpreter.ide;

import com.selenium.exceptions.InvalidSeleneseException;
import com.selenium.exceptions.ParserException;
import com.selenium.steps.IStep;
import java.util.List;

/**
 * Interface for all saved Selenium files
 * @author balnave
 */
public interface ISeleneseParser {
    
    /**
     * Parses the contents of a file and creates a List of ISteps
     * @param content
     * @return
     * @throws InvalidSeleneseException
     * @throws com.selenium.exceptions.ParserException
     */
    public List<IStep> parse(String content) throws InvalidSeleneseException, ParserException;
    
}
