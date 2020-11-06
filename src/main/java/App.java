import domain.Event;
import domain.LogEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.*;

import java.util.List;

public class App {

    private static final Logger LOG = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        LOG.info("*** Application Started ***");

        Reader readingLogFile = new LogFileReader();
        List<LogEvent> logEventsList = readingLogFile.readLogEvents();
        LOG.info("Reading file successfull");

        Parser eventParser = new EventParser();
        List<Event> eventsList = eventParser.parseToEvent(logEventsList);
        LOG.info("Event was parsed successfull");

        Saver eventSaver = new EventSaver();
        eventSaver.saveToDb(eventsList);
        LOG.info("Event was successfully saved to database.");

        LOG.info("*** Operation successfully done!");
        LOG.info("*** Application close!");

    }
}
