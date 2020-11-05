import file.Event;
import file.LogEvent;
import services.EventParser;
import services.EventSaver;
import services.ReadingLogFile;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {

        try {
            List<LogEvent> logEventsList = ReadingLogFile.readLogEvents();

            List<Event> eventsList = EventParser.parseToEvent(logEventsList);

            EventSaver.saveToDb(eventsList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
