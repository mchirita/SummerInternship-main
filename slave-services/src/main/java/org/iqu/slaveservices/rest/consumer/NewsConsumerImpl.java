package org.iqu.slaveservices.rest.consumer;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.iqu.coreservices.config.ServiceInfo;
import org.iqu.slaveservices.entities.News;
import org.iqu.slaveservices.entities.SingleNews;

import orq.iqu.slaveservices.dto.AuthorsDTO;
import orq.iqu.slaveservices.dto.CategoriesDTO;
import orq.iqu.slaveservices.dto.NewsDTO;
import orq.iqu.slaveservices.dto.SingleNewsDTO;
import orq.iqu.slaveservices.dto.SourceDTO;
import orq.iqu.slaveservices.dto.SourcesDTO;

public class NewsConsumerImpl implements NewsConsumer {

  private static final Logger LOGGER = Logger.getLogger(NewsConsumerImpl.class);

  @Override
  public NewsDTO retrieveNews(ServiceInfo serviceInfo) {

    Client client = ClientBuilder.newClient();

    WebTarget webTarget = client
        .target("http://" + serviceInfo.getHostname() + ":" + serviceInfo.getPort() + "/" + serviceInfo.getUrl())
        .path("news");

    Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
    Response response = invocationBuilder.get();

    if (response.getStatus() == 200) {
      News news = response.readEntity(News.class);

      NewsDTO newsDTO = new NewsDTO();
      for (SingleNews newsItem : news.getNews()) {
        newsDTO.add(new SingleNewsDTO(newsItem.getDate(), newsItem.getId(), newsItem.getTitle(), newsItem.getSubtitle(),
            newsItem.getDescription(), newsItem.getAuthors(), newsItem.getCategories(), newsItem.getSource(),
            newsItem.getBody(), newsItem.getImage_id(), newsItem.getThumbnail_id(), newsItem.getExternal_url()));
      }
      return newsDTO;
    }
    if (response.getStatus() == 404) {
      LOGGER.error("News not found!");
    }
    return new NewsDTO();
  }

  @Override
  public AuthorsDTO retrieveAuthors(ServiceInfo serviceInfo) {

    Client client = ClientBuilder.newClient();

    WebTarget webTarget = client
        .target("http://" + serviceInfo.getHostname() + ":" + serviceInfo.getPort() + "/" + serviceInfo.getUrl())
        .path("authors");
    Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
    Response response = invocationBuilder.get();

    if (response.getStatus() == 200) {
      Authors authors = response.readEntity(Authors.class);
      return new AuthorsDTO(authors.getAuthors());
    }
    if (response.getStatus() == 404) {
      LOGGER.error("Authors not found!");
    }
    return new AuthorsDTO();
  }

  @Override
  public CategoriesDTO retrieveCategories(ServiceInfo serviceInfo) {

    Client client = ClientBuilder.newClient();

    WebTarget webTarget = client
        .target("http://" + serviceInfo.getHostname() + ":" + serviceInfo.getPort() + "/" + serviceInfo.getUrl())
        .path("categories");
    Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
    Response response = invocationBuilder.get();

    if (response.getStatus() == 200) {
      Categories categories = response.readEntity(Categories.class);
      return new CategoriesDTO(categories.getCategories());
    }
    if (response.getStatus() == 404) {
      LOGGER.error("Categories not found!");
    }
    return new CategoriesDTO();
  }

  @Override
  public SourcesDTO retrieveSources(ServiceInfo serviceInfo) {

    Client client = ClientBuilder.newClient();

    WebTarget webTarget = client
        .target("http://" + serviceInfo.getHostname() + ":" + serviceInfo.getPort() + "/" + serviceInfo.getUrl())
        .path("sources");

    Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
    Response response = invocationBuilder.get();

    if (response.getStatus() == 200) {
      SourcesDTO sourcesDTO = new SourcesDTO();
      Sources sources = response.readEntity(Sources.class);
      for (Source source : sources.getSources()) {
        sourcesDTO
            .add(new SourceDTO(source.getId(), source.getDisplayName(), source.getDescription(), source.getImage()));

      }
      return sourcesDTO;
    }
    if (response.getStatus() == 404) {
      // error logging
    }
    return new SourcesDTO();

  }
}
