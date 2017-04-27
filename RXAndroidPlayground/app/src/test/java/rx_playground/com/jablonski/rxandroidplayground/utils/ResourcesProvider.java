package rx_playground.com.jablonski.rxandroidplayground.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

/**
 * Created by yabol on 27.04.2017.
 */

public class ResourcesProvider {

    public  String getStringFromResourceile(String fileName){
        InputStream input = this.getClass().getClassLoader().getResourceAsStream(fileName);
        if(input != null){
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            try {
                while((line = reader.readLine()) != null){
                    resultBuilder.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return resultBuilder.toString();

        }
        return null;
    }
}
