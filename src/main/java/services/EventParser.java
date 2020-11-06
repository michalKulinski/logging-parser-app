package services;

import domain.Event;
import domain.LogEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class EventParser implements Parser {

    private final Logger LOG = LogManager.getLogger(EventParser.class);

    @Override
    public List<Event> parseToEvent(List<LogEvent> logEventsList) {

        List<Event> eventList = new ArrayList<>();

        for (LogEvent logEvent : logEventsList) {
            for (LogEvent logEvent2 : logEventsList) {
                if (logEvent.getId().equals(logEvent2.getId()) && logEvent.getState().equals("STARTED") && logEvent2.getState().equals("FINISHED")) {

                    int duration = (int) abs(logEvent.getTimestamp() - logEvent2.getTimestamp());

                    Event event = new Event(logEvent.getId(), duration, logEvent.getType(), logEvent.getHost(), setAlert(duration));

                    if (!eventList.contains(event)) {
                        eventList.add(event);
                        LOG.debug("Successfully parsed and added to EventList: "
                                + "Id = " + event.getId() + " Duration = " + event.getDuration()
                                + " Host = " + event.getHost() + " Type = " + event.getType());
                        break;
                    }
                }
            }
        }

        return eventList;
    }

    private static boolean setAlert(int duration) {
        boolean alert;
        if (duration > 4) {
            alert = true;
        } else {
            alert = false;
        }
        return alert;
    }
}
