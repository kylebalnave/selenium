package com.balnave.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Reads the contents from a URL
 *
 * @author balnave
 */
public class URLReader extends StringReader {

    @Override
    public String load(String fileToRead) {
        HttpURLConnection connection;
        StringBuilder content = new StringBuilder();
        try {
            URL urlToLoad = new URL(fileToRead);
            connection = (HttpURLConnection) urlToLoad.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(String.format("\n%s", inputLine));
            }
            in.close();
            connection.disconnect();
            success = true;
        } catch (MalformedURLException ex) {
            errorMsg = ex.getMessage();
            success = false;
        } catch (IOException ex) {
            errorMsg = ex.getMessage();
            success = false;
        }
        return content.toString();
    }

}
