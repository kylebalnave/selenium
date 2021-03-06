package common.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Reads the contents from a File
 *
 * @author balnave
 */
public class FileReader extends StringReader {

    public FileReader(String fileOrUrl) {
        super(fileOrUrl);
    }

    @Override
    public String load() {
        BufferedReader br;
        StringBuilder content = new StringBuilder();
        try {
            br = new BufferedReader(new java.io.FileReader(fileOrUrl));
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
