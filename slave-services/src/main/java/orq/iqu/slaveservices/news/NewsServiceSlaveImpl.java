package orq.iqu.slaveservices.news;

import java.util.HashSet;
import java.util.Set;

import org.iqu.slaveservices.entities.Authors;
import org.iqu.slaveservices.entities.Categories;
import org.iqu.slaveservices.entities.News;
import org.iqu.slaveservices.entities.Source;

/**
 * NewsServiceSlaveImpl - Class that implements the interface NewsServiceSlave.
 * 
 * @author Alex Dragomir
 *
 */
public class NewsServiceSlaveImpl implements NewsServiceSlave {

	/**
	 * This method is used to return a set of authors.
	 */
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

	/**
	 * This method is used to return a set of categories.
	 */
	@Override
	public Set<String> retrieveCategories() {
		Categories categories = new Categories();

		// ToDo get categories from db.
		categories.addCategory("music");
		categories.addCategory("music");
		categories.addCategory("politics");
		categories.addCategory("IT");

		return categories.getCategories();
	}

	/**
	 * This method is used to return a set of news.
	 */
	@Override
	public Set<News> retrieveNews(String startDate, String endDate, String categories, String about, String sourceId,
			String author, String location) {
		// TODO get news from db.
		Set<News> news = new HashSet<News>();
		news.add(new News());
		return news;
	}

	/**
	 * This method is used to return a set of sources.
	 */
	@Override
	public Set<Source> retrieveSources() {
		// TODO get sources from db.
		Set<Source> sources = new HashSet<Source>();
		sources.add(new Source("id", "display name", "description"));
		return sources;
	}

}
