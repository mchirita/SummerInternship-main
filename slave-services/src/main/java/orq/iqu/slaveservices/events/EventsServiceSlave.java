package orq.iqu.slaveservices.events;

import orq.iqu.slaveservices.dto.AuthorsDTO;
import orq.iqu.slaveservices.dto.EventsDTO;
import orq.iqu.slaveservices.dto.SourcesDTO;
import orq.iqu.slaveservices.dto.TypesDTO;

/**
 * EventsServiceSlave - Interface.
 * 
 * @author Alex Dragomir
 *
 */
public interface EventsServiceSlave {

  /**
   * This method is used to return a set of authors.
   */
  AuthorsDTO retrieveAuthors();

  /**
   * This method is used to return a set of events.
   */
  EventsDTO retrieveEvents(String startDate, String endDate, String type, String subType, String sourceId,
      String author, String location);

  /**
   * This method is used to return a set of sources.
   */
  SourcesDTO retrieveSources();

  /**
   * This method is used to return a set of service types.
   */
  TypesDTO retrieveTypes();
}
