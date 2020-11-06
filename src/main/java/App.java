import file.Event;
import file.LogEvent;
import javafx.application.Application;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.EventParser;
import services.EventSaver;
import services.ReadingLogFile;

import java.io.IOException;
import java.util.List;

public class App {

    private static final Logger LOG = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        try {
            LOG.info("*** Application Started ***");

            List<LogEvent> logEventsList = ReadingLogFile.readLogEvents();
            LOG.info("Reading file successfull");

            List<Event> eventsList = EventParser.parseToEvent(logEventsList);
            LOG.info("Event was parsed successfull");

            EventSaver.saveToDb(eventsList);
            LOG.info("Event was successfully saved to database.");

            LOG.info("*** Operation successfully done!");
            LOG.info("*** Application close!");

        } catch (IOException e) {
            LOG.error("Cannot read file: " + e);
        }
    }
}
