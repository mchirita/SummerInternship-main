package orq.iqu.slaveservices.news;

import java.util.Set;

import org.iqu.slaveservices.entities.Authors;
import org.iqu.slaveservices.entities.Categories;
import org.iqu.slaveservices.entities.News;
import org.iqu.slaveservices.entities.Source;

/**
 * NewsServiceSlave - Interface.
 * 
 * @author Alex Dragomir
 *
 */
public interface NewsServiceSlave {

	/**
	 * This method is used to return a set of authors.
	 */
	public Authors retrieveAuthors();

	/**
	 * This method is used to return a set of categories.
	 */
	public Categories retrieveCategories();

	/**
	 * This method is used to return a set of news.
	 */
	public Set<News> retrieveNews(String startDate, String endDate, String categories, String about, String sourceId,
			String author, String location);

	/**
	 * This method is used to return a set of sources.
	 */
	public Set<Source> retrieveSources();

}
