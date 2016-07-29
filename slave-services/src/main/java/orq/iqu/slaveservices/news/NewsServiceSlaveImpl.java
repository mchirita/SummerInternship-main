package orq.iqu.slaveservices.news;

import org.iqu.coreservices.config.ConfigServicesManager;
import org.iqu.coreservices.config.ServiceInfo;
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

  private ConfigServicesManager configServicesManager = ConfigServicesManager.getInstance();

  /**
   * This method is used to return a set of authors.
   */
  @Override
  public AuthorsDTO retrieveAuthors() {
    AuthorsDTO authorsDTO = new AuthorsDTO();
    for (ServiceInfo serviceInfo : configServicesManager.getSlaveApps()) {
      AuthorsDTO dto = ConsumerFactory.getNewsConsumerInstance().retrieveAuthors(serviceInfo);
      authorsDTO.getAuthors().addAll(dto.getAuthors());
    }
    return authorsDTO;
  }

  /**
   * This method is used to return a set of categories.
   */
  @Override
  public CategoriesDTO retrieveCategories() {
    CategoriesDTO categoriesDTO = new CategoriesDTO();
    for (ServiceInfo serviceInfo : configServicesManager.getSlaveApps()) {
      CategoriesDTO dto = ConsumerFactory.getNewsConsumerInstance().retrieveCategories(serviceInfo);
      categoriesDTO.getCategories().addAll(dto.getCategories());
    }
    return categoriesDTO;
  }

  /**
   * This method is used to return a set of news.
   */
  @Override
  public NewsDTO retrieveNews(String startDate, String endDate, String categories, String about, String sourceId,
      String author, String location) {

    NewsDTO newsDTO = new NewsDTO();
    for (ServiceInfo serviceInfo : configServicesManager.getSlaveApps()) {
      NewsDTO dto = ConsumerFactory.getNewsConsumerInstance().retrieveNews(serviceInfo,
          "?startDate=" + startDate + "&endaDate=" + endDate + "&categories=" + categories + "&about=" + about
              + "&sourceId=" + sourceId + "&author=" + author + "&location=" + location);
      newsDTO.getNews().addAll(dto.getNews());
    }
    return newsDTO;
  }

  /**
   * This method is used to return a set of sources.
   */
  @Override
  public SourcesDTO retrieveSources() {
    SourcesDTO sourcesDTO = new SourcesDTO();
    for (ServiceInfo serviceInfo : configServicesManager.getSlaveApps()) {
      SourcesDTO dto = ConsumerFactory.getNewsConsumerInstance().retrieveSources(serviceInfo);
      sourcesDTO.getSources().addAll(dto.getSources());
    }

    return sourcesDTO;
  }

}
