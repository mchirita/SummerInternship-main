package orq.iqu.slaveservices.dto;

import java.util.HashSet;
import java.util.Set;

import org.iqu.slaveservices.entities.Event;

public class EventsDTO {
	private Set<Event> events = new HashSet<Event>();

	public EventsDTO() {

	}

	public EventsDTO(Set<Event> events) {
		super();
		this.events = events;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

}
