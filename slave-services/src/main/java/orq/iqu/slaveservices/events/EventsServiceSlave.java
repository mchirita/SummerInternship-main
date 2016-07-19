package orq.iqu.slaveservices.events;

import java.util.Set;

import org.iqu.slaveservices.entities.Event;
import org.iqu.slaveservices.entities.Source;
import org.iqu.slaveservices.entities.TypeService;

public interface EventsServiceSlave {

	public Set<String> retrieveAuthors();

	public Set<Event> retrieveEvents(String startDate, String endDate, String type, String subType, String sourceId,
			String author, String location);

	public Set<Source> retrieveSources();

	public Set<TypeService> retrieveTypes();
}
