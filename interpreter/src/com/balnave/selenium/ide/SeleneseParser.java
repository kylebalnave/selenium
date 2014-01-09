package com.balnave.selenium.ide;

import java.util.List;

/**
 * Interface for all saved Selenium files
 * @author balnave
 */
public interface SeleneseParser {
    
    public List<Object> parse(String content);
    
}
