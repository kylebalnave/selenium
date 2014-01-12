package common.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Writes a String to a file
 *
 * @author balnave
 */
public class StringWriter {

    public boolean write(File file, String content) {
        try {
            String dirPath = file.getAbsolutePath().replace(file.getName(), "");
            File dir = new File(dirPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

}
