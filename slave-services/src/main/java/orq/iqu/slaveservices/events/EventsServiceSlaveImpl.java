package orq.iqu.slaveservices.events;

import java.util.HashSet;
import java.util.Set;

import org.iqu.coreservices.config.ServiceInfo;
import org.iqu.slaveservices.entities.Event;
import org.iqu.slaveservices.entities.Source;
import org.iqu.slaveservices.entities.TypeService;
import org.iqu.slaveservices.rest.consumer.EventsConsumer;
import org.iqu.slaveservices.rest.consumer.factory.ConsumerFactory;

import orq.iqu.slaveservices.dto.AuthorsDTO;

/**
 * EventsServiceSlaveImpl - Class that implements the interface
 * EventsServiceSlave.
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
	 * This method is used to return a set of events.
	 */
	@Override
	public Set<Event> retrieveEvents(String startDate, String endDate, String type, String subType, String sourceId,
			String author, String location) {
		// TODO get events from db.
		Set<Event> events = new HashSet<Event>();
		events.add(new Event());
		return events;
	}

	/**
	 * This method is used to return a set of sources.
	 */
	@Override
	public Set<Source> retrieveSources() {
		// TODO get source from db.
		Set<Source> sources = new HashSet<Source>();
		sources.add(new Source("id", "display name", "description"));
		return sources;
	}

	/**
	 * This method is used to return a set of service types.
	 */
	@Override
	public Set<TypeService> retrieveTypes() {
		// TODO get types from db.
		Set<TypeService> types = new HashSet<TypeService>();
		types.add(new TypeService());
		return types;
	}

}
