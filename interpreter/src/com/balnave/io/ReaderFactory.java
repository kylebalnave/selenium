package com.balnave.io;

/**
 * Returns the correct Reader type
 * @author balnave
 */
public class ReaderFactory {
    
    public StringReader getReader(String fileOrUrl) {
        if(fileOrUrl.matches("^(http|https|ftp):\\/\\/.*$")) {
            return new URLReader(fileOrUrl);
        }
        return new FileReader(fileOrUrl);
    }
    
}
