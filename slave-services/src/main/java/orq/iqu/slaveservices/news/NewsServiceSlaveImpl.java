package orq.iqu.slaveservices.news;

import java.util.Set;

import org.iqu.coreservices.config.ServiceInfo;
import org.iqu.slaveservices.entities.Authors;
import org.iqu.slaveservices.entities.Categories;
import org.iqu.slaveservices.entities.News;
import org.iqu.slaveservices.entities.Source;
import org.iqu.slaveservices.rest.consumer.NewsConsumer;
import org.iqu.slaveservices.rest.consumer.factory.ConsumerFactory;

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
	public Authors retrieveAuthors() {

		return newsConsumerInstance.retrieveAuthors(new ServiceInfo("localhost", "8080", "web-crawler/news/"));

	}

	/**
	 * This method is used to return a set of categories.
	 */
	@Override
	public Categories retrieveCategories() {

		return newsConsumerInstance.retrieveCategories(new ServiceInfo("localhost", "8080", "web-crawler/news/"));

	}

	/**
	 * This method is used to return a set of news.
	 */
	@Override
	public Set<News> retrieveNews(String startDate, String endDate, String categories, String about, String sourceId,
			String author, String location) {
		// TODO get news from db.
		Set<News> news = newsConsumerInstance.retrieveNews(new ServiceInfo("localhost", "8080", "web-crawler/"));
		return news;
	}

	/**
	 * This method is used to return a set of sources.
	 */
	@Override
	public Set<Source> retrieveSources() {
		// TODO get sources from db.
		// Set<Source> sources = new HashSet<Source>();
		// sources.add(new Source("id", "display name", "description"));
		Set<Source> sources = newsConsumerInstance
				.retrieveSources(new ServiceInfo("localhost", "8080", "web-crawler/news/"));
		return sources;
	}

}
