package orq.iqu.slaveservices.events;

import org.iqu.coreservices.config.ConfigServicesManager;
import org.iqu.coreservices.config.ServiceInfo;
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

  private ConfigServicesManager configServicesManager = ConfigServicesManager.getInstance();

  /**
   * This method is used to return a set of authors.
   */
  @Override
  public AuthorsDTO retrieveAuthors() {
    AuthorsDTO authorsDTO = new AuthorsDTO();
    for (ServiceInfo serviceInfo : configServicesManager.getSlaveApps()) {
      AuthorsDTO dto = ConsumerFactory.getEventsConsumerInstance().retrieveAuthors(serviceInfo);
      authorsDTO.getAuthors().addAll(dto.getAuthors());
    }
    return authorsDTO;
  }

  /**
   * This method is used to return a set of categories.
   */
  @Override
  public TypesDTO retrieveTypes() {

    TypesDTO typesDTO = new TypesDTO();
    for (ServiceInfo serviceInfo : configServicesManager.getSlaveApps()) {
      TypesDTO dto = ConsumerFactory.getEventsConsumerInstance().retrieveTypes(serviceInfo);
      typesDTO.getTypes().addAll(dto.getTypes());
    }

    return typesDTO;
  }

  /**
   * This method is used to return a set of news.
   */
  @Override
  public EventsDTO retrieveEvents(String startDate, String endDate, String type, String subtype, String sourceId,
      String author, String location) {

    EventsDTO eventsDTO = new EventsDTO();
    for (ServiceInfo serviceInfo : configServicesManager.getSlaveApps()) {
      EventsDTO dto = ConsumerFactory.getEventsConsumerInstance().retrieveEvents(serviceInfo,
          "?startDate=" + startDate + "&endDate=" + endDate + "&type=" + type + "&subtype=" + subtype + "&sourceId="
              + sourceId + "&author=" + author + "&location=" + location);
      eventsDTO.getEvents().addAll(dto.getEvents());
    }
    return eventsDTO;
  }

  /**
   * This method is used to return a set of sources.
   */
  @Override
  public SourcesDTO retrieveSources() {

    SourcesDTO sourcesDTO = new SourcesDTO();
    for (ServiceInfo serviceInfo : configServicesManager.getSlaveApps()) {
      SourcesDTO dto = ConsumerFactory.getEventsConsumerInstance().retrieveSources(serviceInfo);
      sourcesDTO.getSources().addAll(dto.getSources());
    }

    return sourcesDTO;
  }

}
