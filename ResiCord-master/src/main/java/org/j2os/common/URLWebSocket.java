package org.j2os.common;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

@UtilityClass
public class URLWebSocket {

    public String getStringContent(String stringURL) throws IOException {
        URL url = new URL(stringURL);
        URLConnection urlConnection = url.openConnection();
        StringBuilder stringBuilder = new StringBuilder();
        try (InputStream inputStream = urlConnection.getInputStream()) {
            int ascii = 0;
            while (ascii != -1) {
                ascii = inputStream.read();
                stringBuilder.append((char) ascii);
            }
        }
        return stringBuilder.toString();
    }
}
