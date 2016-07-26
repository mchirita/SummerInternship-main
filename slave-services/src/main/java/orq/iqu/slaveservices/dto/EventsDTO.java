package orq.iqu.slaveservices.dto;

import java.util.HashSet;
import java.util.Set;

public class EventsDTO {
  private Set<EventDTO> events = new HashSet<EventDTO>();

  public EventsDTO() {

  }

  public EventsDTO(Set<EventDTO> events) {
    super();
    this.events = events;
  }

  public Set<EventDTO> getEvents() {
    return events;
  }

  public void setEvents(Set<EventDTO> events) {
    this.events = events;
  }

  public void add(EventDTO event) {
    events.add(event);
  }

}
