package org.iqu.slaveservices.rest.consumer.models;

import java.util.HashSet;
import java.util.Set;

/**
 * Class that implements a set of Events
 * 
 * @author iQuest
 *
 */
public class EventsModel {

  private Set<EventModel> events = new HashSet<EventModel>();

  public EventsModel(Set<EventModel> events) {
    super();
    this.events = events;
  }

  public EventsModel() {
    // TODO Auto-generated constructor stub
  }

  public void addEvent(EventModel event) {
    events.add(event);
  }

  public void removeEvent(EventModel event) {
    events.remove(event);
  }

  public Set<EventModel> getEvents() {
    return events;
  }

  public void setEvents(Set<EventModel> events) {
    this.events = events;
  }

  public void add(EventModel event) {
    events.add(event);
  }

}
