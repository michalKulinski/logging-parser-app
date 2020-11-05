package services;

import com.google.gson.Gson;
import file.LogEvent;
import utils.GettingProperties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadingLogFile {

    public static List<LogEvent> readLogEvents() throws IOException {
        GettingProperties prop = new GettingProperties();
        List<LogEvent> logEventsList = new ArrayList<>();
        Gson gson = new Gson();
        String line;

        BufferedReader bufferedReader = new BufferedReader(new FileReader("./" + prop.getProperties().getProperty("logfile")));

        while ((line = bufferedReader.readLine()) != null) {
            logEventsList.add(gson.fromJson(line, LogEvent.class));
        }
        return logEventsList;
    }
}
