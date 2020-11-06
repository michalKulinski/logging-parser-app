package services;

import file.Event;
import dao.EventDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class EventSaver {

    private static final Logger LOG = LogManager.getLogger(EventSaver.class);

    public static void saveToDb(List<Event> eventsList){

        EventDao eventDao = new EventDao();

        LOG.info("Saving data");

        for (Event event : eventsList) {
            eventDao.insertData(event);
            LOG.info("New " + ((event.getHost() != null) ? "server" : "application") + " event: "
                    + event.getId() + " was successfully saved");
        }
    }
}
