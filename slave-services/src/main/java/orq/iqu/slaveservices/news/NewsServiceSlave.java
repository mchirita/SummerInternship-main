package orq.iqu.slaveservices.news;

import java.util.Set;

import org.iqu.slaveservices.entities.News;
import org.iqu.slaveservices.entities.Source;

public interface NewsServiceSlave {

	public Set<String> retrieveAuthors();

	public Set<String> retrieveCategories();

	public Set<News> retrieveNews(String startDate, String endDate, String categories, String about, String sourceId,
			String author, String location);

	public Set<Source> retrieveSources();

}
