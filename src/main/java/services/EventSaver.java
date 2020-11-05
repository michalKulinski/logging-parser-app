package services;

import file.Event;
import dao.EventDao;

import java.util.List;

public class EventSaver {

    public static void saveToDb(List<Event> eventsList){

        EventDao eventDao = new EventDao();

        for (Event event : eventsList) {
            eventDao.insertData(event);
        }
    }
}
