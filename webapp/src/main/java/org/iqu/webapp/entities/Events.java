package org.iqu.webapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class that implements a set of Events
 * 
 * @author iQuest
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
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

  @XmlElement
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
