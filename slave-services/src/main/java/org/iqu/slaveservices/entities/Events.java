package org.iqu.slaveservices.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * Class that implements a set of Events
 * 
 * @author iQuest
 *
 */
public class Events {

  private Set<Event> events = new HashSet<Event>();

  public Events(Set<Event> events) {
    super();
    this.events = events;
  }

  public Events() {
    // TODO Auto-generated constructor stub
  }

  public void addEvent(Event event) {
    events.add(event);
  }

  public void removeEvent(Event event) {
    events.remove(event);
  }

  public Set<Event> getEvents() {
    return events;
  }

  public void setEvents(Set<Event> events) {
    this.events = events;
  }

  public void add(Event event) {
    events.add(event);
  }

}
