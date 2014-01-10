package com.balnave.selenium.interpreter.ide;

import com.balnave.selenium.interpreter.steps.IStep;
import java.util.List;

/**
 * Interface for all saved Selenium files
 * @author balnave
 */
public interface ISeleneseParser {
    
    public List<IStep> parse(String content);
    
}
