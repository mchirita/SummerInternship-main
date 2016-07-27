package orq.iqu.slaveservices.events;

import org.iqu.coreservices.config.ServiceInfo;
import org.iqu.slaveservices.rest.consumer.EventsConsumer;
import org.iqu.slaveservices.rest.consumer.factory.ConsumerFactory;

import orq.iqu.slaveservices.dto.AuthorsDTO;
import orq.iqu.slaveservices.dto.EventsDTO;
import orq.iqu.slaveservices.dto.SourcesDTO;
import orq.iqu.slaveservices.dto.TypesDTO;

/**
 * NewsServiceSlaveImpl - Class that implements the interface NewsServiceSlave.
 * 
 * @author Alex Dragomir
 *
 */
public class EventsServiceSlaveImpl implements EventsServiceSlave {

  private EventsConsumer eventsConsumerInstance = ConsumerFactory.getEventsConsumerInstance();

  /**
   * This method is used to return a set of authors.
   */
  @Override
  public AuthorsDTO retrieveAuthors() {

    return eventsConsumerInstance.retrieveAuthors(new ServiceInfo("localhost", "8080", "web-crawler/events/"));

  }

  /**
   * This method is used to return a set of categories.
   */
  @Override
  public TypesDTO retrieveTypes() {

    return eventsConsumerInstance.retrieveTypes(new ServiceInfo("localhost", "8080", "web-crawler/events/"));

  }

  /**
   * This method is used to return a set of news.
   */
  @Override
  public EventsDTO retrieveEvents(String startDate, String endDate, String type, String subtype, String sourceId,
      String author, String location) {
    return eventsConsumerInstance.retrieveEvents(new ServiceInfo("localhost", "8080",
        "web-crawler/events?startDate=" + startDate + "&endDate=" + endDate + "&type=" + type + "subtype=" + subtype
            + "&sourceId=" + sourceId + "&author=" + author + "&location=" + location));
  }

  /**
   * This method is used to return a set of sources.
   */
  @Override
  public SourcesDTO retrieveSources() {
    return eventsConsumerInstance.retrieveSources(new ServiceInfo("localhost", "8080", "web-crawler/events/"));
  }

}
