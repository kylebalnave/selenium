package common.io;

/**
 * Abstract Class to read the contents of a file
 * @author balnave
 */
public abstract class StringReader {
    
    protected final String fileOrUrl;
    protected String errorMsg;
    protected boolean success;

    public StringReader(String fileOrUrl) {
        this.fileOrUrl = fileOrUrl;
    }
     
    public abstract String load();
    
    public boolean isReady() {
        return success == true;
    }
    
    public String getErrorMsg() {
        return errorMsg == null ? "Unknown Error!" : errorMsg;
    }
}
