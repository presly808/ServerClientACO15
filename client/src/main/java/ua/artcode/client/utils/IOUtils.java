package ua.artcode.client.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by serhii on 9/25/16.
 */
public class IOUtils {
    public static String readAll(InputStream content) throws IOException {
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(content));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        return result.toString();
    }
}
