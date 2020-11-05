package services;

import file.Event;
import file.LogEvent;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class EventParser {

    public static List<Event> parseToEvent(List<LogEvent> logEventsList) {

        List<Event> eventList = new ArrayList<>();

        for (LogEvent logEvent : logEventsList) {
            for (LogEvent logEvent2 : logEventsList) {
                if (logEvent.getId().equals(logEvent2.getId()) && logEvent.getState().equals("STARTED") && logEvent2.getState().equals("FINISHED")) {

                    int duration = (int) abs(logEvent.getTimestamp() - logEvent2.getTimestamp());

                    Event event = new Event(logEvent.getId(), duration, logEvent.getType(), logEvent.getHost(), setAlert(duration));

                    if (!eventList.contains(event)) {
                        eventList.add(event);
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
