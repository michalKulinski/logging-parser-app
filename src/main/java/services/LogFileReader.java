package services;

import com.google.gson.Gson;
import domain.LogEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.GettingProperties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogFileReader implements Reader {

    private final Logger LOG = LogManager.getLogger(LogFileReader.class);
    private GettingProperties prop = new GettingProperties();
    private String pathToFile;
    private String fileName;

    @Override
    public List<LogEvent> readLogEvents() {

        fileName = prop.getProperties().getProperty("logfile");
        pathToFile = "./" + fileName;

        List<LogEvent> logEventsList = new ArrayList<>();
        Gson gson = new Gson();
        String line;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile));
            LOG.info("Reading the logfile: " + fileName);

            while ((line = bufferedReader.readLine()) != null) {
                logEventsList.add(gson.fromJson(line, LogEvent.class));
                LOG.debug("Reading line and adding to list: " + line);
            }
        } catch (IOException e) {
            LOG.error("Cannot read file: " + e);
        }
        return logEventsList;
    }
}
