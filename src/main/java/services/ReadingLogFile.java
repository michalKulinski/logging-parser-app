package services;

import com.google.gson.Gson;
import file.LogEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.GettingProperties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadingLogFile {

    private static final Logger LOG = LogManager.getLogger(ReadingLogFile.class);
    private static GettingProperties prop = new GettingProperties();
    private static final String fileName = prop.getProperties().getProperty("logfile");

public static List<LogEvent> readLogEvents() throws IOException {

        List<LogEvent> logEventsList = new ArrayList<>();
        Gson gson = new Gson();
        String line;

        BufferedReader bufferedReader = new BufferedReader(new FileReader("./" + fileName));
        LOG.info("Reading the logfile: " + fileName);

        while ((line = bufferedReader.readLine()) != null) {
            logEventsList.add(gson.fromJson(line, LogEvent.class));
            LOG.debug("Reading line and adding to list: " + line);
        }
        return logEventsList;
    }
}
