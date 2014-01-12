package common.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author balnave
 */
public class ResourceReader extends StringReader {

    public ResourceReader(String fileOrUrl) {
        super(fileOrUrl);
    }

    @Override
    public String load() {
        BufferedReader br;
        InputStream stream = getClass().getResourceAsStream(fileOrUrl);
        StringBuilder content = new StringBuilder();
        try {
            br = new BufferedReader(new InputStreamReader(stream));
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
        return content.substring(0);
    }

}
