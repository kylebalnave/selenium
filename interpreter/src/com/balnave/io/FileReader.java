package com.balnave.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Reads the contents from a File
 *
 * @author balnave
 */
public class FileReader extends StringReader {

    @Override
    public String load(String pathToRead) {
        BufferedReader br;
        StringBuilder content = new StringBuilder();
        try {
            br = new BufferedReader(new java.io.FileReader(pathToRead));
            String line = br.readLine();
            while (line != null) {
                content.append(String.format("\n%s", line));
                line = br.readLine();
            }
            br.close();
            success = true;
        } catch (FileNotFoundException ex) {
            errorMsg = ex.getMessage();
            success = false;
        } catch (IOException ex) {
            errorMsg = ex.getMessage();
            success = false;
        }
        return content.toString();
    }

}
