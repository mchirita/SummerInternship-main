package orq.iqu.slaveservices.news;

import java.util.Set;

import org.iqu.slaveservices.entities.Authors;
import org.iqu.slaveservices.entities.Categories;
import org.iqu.slaveservices.entities.News;
import org.iqu.slaveservices.entities.Source;

public class NewsServiceImpl implements NewsService {

	@Override
	public Set<String> retrieveAuthors() {
		Authors authors = new Authors();

		// ToDo get authors from db.
		authors.addAuthor("Iron Maiden");
		// authors.addAuthor("Amy Lee");
		// authors.addAuthor("Passenger");
		// authors.addAuthor("iQuest");
		return authors.getAuthors();
	}

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

	@Override
	public Set<News> retrieveNews(String startDate, String endDate, String categories, String about, String sourceId,
			String author, String location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Source> retrieveSources() {
		// TODO Auto-generated method stub
		return null;
	}

}
