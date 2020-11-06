package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GettingProperties {

    private Properties prop;
    private static final Logger LOG = LogManager.getLogger(GettingProperties.class);

    public Properties getProperties() {

        try (InputStream input = new FileInputStream("src/main/resources/application.properties")) {

            prop = new Properties();

            prop.load(input);

        } catch (IOException e) {
            LOG.error("Cannot read properties file: " + e);
        }
        return prop;
    }
}
