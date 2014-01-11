package com.balnave.selenium.interpreter.ide;

import com.balnave.selenium.exceptions.InvalidSeleneseException;
import com.balnave.selenium.exceptions.ParserException;
import com.balnave.selenium.steps.IStep;
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
     * @throws com.balnave.selenium.exceptions.ParserException
     */
    public List<IStep> parse(String content) throws InvalidSeleneseException, ParserException;
    
}
