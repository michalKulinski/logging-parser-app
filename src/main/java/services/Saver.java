package services;

import domain.Event;

import java.util.List;

public interface Saver {

    void saveToDb(List<Event> eventsList);

}
