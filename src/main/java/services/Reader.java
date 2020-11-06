package services;

import domain.LogEvent;

import java.util.List;

public interface Reader {

    List<LogEvent> readLogEvents();

}
