package com.balnave.io;

/**
 * Abstract Class to read a file
 * @author balnave
 */
public abstract class StringReader {
    
    protected String errorMsg;
    protected boolean success;
            
    public abstract String load(String fileToRead);
    
    public boolean isReady() {
        return success == true;
    }
    
    public String getErrorMsg() {
        return errorMsg == null ? "Unknown Error!" : errorMsg;
    }
}
