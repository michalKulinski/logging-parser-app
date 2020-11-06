package services;

import domain.Event;
import domain.LogEvent;

import java.util.List;

public interface Parser {

    List<Event> parseToEvent(List<LogEvent> logEventsList);

}
