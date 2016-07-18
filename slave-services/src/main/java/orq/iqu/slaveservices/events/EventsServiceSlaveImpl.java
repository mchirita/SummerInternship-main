package orq.iqu.slaveservices.events;

import java.util.Set;

import org.iqu.slaveservices.entities.Authors;
import org.iqu.slaveservices.entities.Event;
import org.iqu.slaveservices.entities.Source;
import org.iqu.slaveservices.entities.TypeService;

public class EventsServiceImpl implements EventsService {

	@Override
	public Set<String> retrieveAuthors() {
		Authors authors = new Authors();

		// ToDo get authors from db.
		authors.addAuthor("Iron Maiden");
		authors.addAuthor("Amy Lee");
		authors.addAuthor("Passenger");
		authors.addAuthor("iQuest");
		return authors.getAuthors();
	}

	@Override
	public Set<Event> retrieveEvents(String startDate, String endDate, String type, String subType, String sourceId,
			String author, String location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Source> retrieveSources() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<TypeService> retrieveTypes() {
		// TODO Auto-generated method stub
		return null;
	}

}
