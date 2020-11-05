package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GettingProperties {

    private Properties prop;

    public Properties getProperties() {

        try (InputStream input = new FileInputStream("src/main/resources/application.properties")) {

            prop = new Properties();

            prop.load(input);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
