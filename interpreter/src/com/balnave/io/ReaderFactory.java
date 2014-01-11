package com.balnave.io;

/**
 * Returns a StringReader
 * @author balnave
 */
public class ReaderFactory {
    
    public StringReader getReader(String fileOrUrl) {
        StringReader reader;
        if(fileOrUrl.matches("^(http|https|ftp):\\/\\/.*$")) {
            reader = new URLReader(fileOrUrl);
        }
        reader = new FileReader(fileOrUrl);
        return reader;
    }
    
}
