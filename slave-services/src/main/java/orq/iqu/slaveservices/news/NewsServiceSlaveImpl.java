package orq.iqu.slaveservices.news;

import org.iqu.coreservices.config.ServiceInfo;
import org.iqu.slaveservices.rest.consumer.NewsConsumer;
import org.iqu.slaveservices.rest.consumer.factory.ConsumerFactory;

import orq.iqu.slaveservices.dto.AuthorsDTO;
import orq.iqu.slaveservices.dto.CategoriesDTO;
import orq.iqu.slaveservices.dto.NewsDTO;
import orq.iqu.slaveservices.dto.SourcesDTO;

/**
 * NewsServiceSlaveImpl - Class that implements the interface NewsServiceSlave.
 * 
 * @author Alex Dragomir
 *
 */
public class NewsServiceSlaveImpl implements NewsServiceSlave {

	private NewsConsumer newsConsumerInstance = ConsumerFactory.getNewsConsumerInstance();

	/**
	 * This method is used to return a set of authors.
	 */
	@Override
	public AuthorsDTO retrieveAuthors() {

		return newsConsumerInstance.retrieveAuthors(new ServiceInfo("localhost", "8080", "web-crawler/news/"));

	}

	/**
	 * This method is used to return a set of categories.
	 */
	@Override
	public CategoriesDTO retrieveCategories() {

		return newsConsumerInstance.retrieveCategories(new ServiceInfo("localhost", "8080", "web-crawler/news/"));

	}

	/**
	 * This method is used to return a set of news.
	 */
	@Override
	public NewsDTO retrieveNews(String startDate, String endDate, String categories, String about, String sourceId,
			String author, String location) {
		// TODO get news from db.
		return newsConsumerInstance.retrieveNews(new ServiceInfo("localhost", "8080", "web-crawler/"));
	}

	/**
	 * This method is used to return a set of sources.
	 */
	@Override
	public SourcesDTO retrieveSources() {
		return newsConsumerInstance.retrieveSources(new ServiceInfo("localhost", "8080", "web-crawler/news/"));
	}

}
