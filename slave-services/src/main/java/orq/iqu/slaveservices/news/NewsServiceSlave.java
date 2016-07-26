package orq.iqu.slaveservices.news;

import orq.iqu.slaveservices.dto.AuthorsDTO;
import orq.iqu.slaveservices.dto.CategoriesDTO;
import orq.iqu.slaveservices.dto.NewsDTO;
import orq.iqu.slaveservices.dto.SourcesDTO;

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
	public AuthorsDTO retrieveAuthors();

	/**
	 * This method is used to return a set of categories.
	 */
	public CategoriesDTO retrieveCategories();

	/**
	 * This method is used to return a set of news.
	 */
	public NewsDTO retrieveNews(String startDate, String endDate, String categories, String about, String sourceId,
			String author, String location);

	/**
	 * This method is used to return a set of sources.
	 */
	public SourcesDTO retrieveSources();

}
