package orq.iqu.slaveservices.events;

import java.util.Set;

import org.iqu.slaveservices.entities.Event;
import org.iqu.slaveservices.entities.Source;
import org.iqu.slaveservices.entities.TypeService;

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
	public Set<String> retrieveAuthors();

	/**
	 * This method is used to return a set of events.
	 */
	public Set<Event> retrieveEvents(String startDate, String endDate, String type, String subType, String sourceId,
			String author, String location);

	/**
	 * This method is used to return a set of sources.
	 */
	public Set<Source> retrieveSources();

	/**
	 * This method is used to return a set of service types.
	 */
	public Set<TypeService> retrieveTypes();
}
