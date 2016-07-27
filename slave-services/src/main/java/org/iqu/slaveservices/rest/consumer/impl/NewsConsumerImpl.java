package org.iqu.slaveservices.rest.consumer.impl;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.iqu.coreservices.config.ServiceInfo;
import org.iqu.slaveservices.rest.consumer.BaseConsumer;
import org.iqu.slaveservices.rest.consumer.NewsConsumer;
import org.iqu.slaveservices.rest.consumer.models.AuthorsModel;
import org.iqu.slaveservices.rest.consumer.models.CategoriesModel;
import org.iqu.slaveservices.rest.consumer.models.NewsModel;
import org.iqu.slaveservices.rest.consumer.models.SingleNewsModel;
import org.iqu.slaveservices.rest.consumer.models.SourceModel;
import org.iqu.slaveservices.rest.consumer.models.SourcesModel;

import orq.iqu.slaveservices.dto.AuthorsDTO;
import orq.iqu.slaveservices.dto.CategoriesDTO;
import orq.iqu.slaveservices.dto.NewsDTO;
import orq.iqu.slaveservices.dto.SingleNewsDTO;
import orq.iqu.slaveservices.dto.SourceDTO;
import orq.iqu.slaveservices.dto.SourcesDTO;

public class NewsConsumerImpl extends BaseConsumer implements NewsConsumer {

  private static final Logger LOGGER = Logger.getLogger(NewsConsumerImpl.class);

  @Override
  public NewsDTO retrieveNews(ServiceInfo serviceInfo) {

    Client client = ClientBuilder.newClient();

    WebTarget webTarget = client.target(buildTarget(serviceInfo));

    Response response = webTarget.request(MediaType.APPLICATION_JSON).get();

    if (response.getStatus() == Status.OK.getStatusCode()) {
      NewsModel news = response.readEntity(NewsModel.class);

      NewsDTO newsDTO = new NewsDTO();
      for (SingleNewsModel newsItem : news.getNews()) {
        newsDTO.add(new SingleNewsDTO(newsItem.getDate(), newsItem.getId(), newsItem.getTitle(), newsItem.getSubtitle(),
            newsItem.getDescription(), newsItem.getAuthors(), newsItem.getCategories(), newsItem.getSource(),
            newsItem.getBody(), newsItem.getImage_id(), newsItem.getThumbnail_id(), newsItem.getExternal_url()));
      }
      return newsDTO;
    }
    if (response.getStatus() == Status.NOT_FOUND.getStatusCode()) {
      LOGGER.error("News not found!");
    }
    return new NewsDTO();
  }

  @Override
  public AuthorsDTO retrieveAuthors(ServiceInfo serviceInfo) {

    Client client = ClientBuilder.newClient();

    WebTarget webTarget = client.target(buildTarget(serviceInfo)).path("authors");
    Response response = webTarget.request(MediaType.APPLICATION_JSON).get();

    if (response.getStatus() == Status.OK.getStatusCode()) {
      AuthorsModel authors = response.readEntity(AuthorsModel.class);
      return new AuthorsDTO(authors.getAuthors());
    }
    if (response.getStatus() == Status.NOT_FOUND.getStatusCode()) {
      LOGGER.error("Authors not found!");
    }
    return new AuthorsDTO();
  }

  @Override
  public CategoriesDTO retrieveCategories(ServiceInfo serviceInfo) {

    Client client = ClientBuilder.newClient();

    WebTarget webTarget = client.target(buildTarget(serviceInfo)).path("categories");
    Response response = webTarget.request(MediaType.APPLICATION_JSON).get();

    if (response.getStatus() == Status.OK.getStatusCode()) {
      CategoriesModel categories = response.readEntity(CategoriesModel.class);
      return new CategoriesDTO(categories.getCategories());
    }
    if (response.getStatus() == Status.NOT_FOUND.getStatusCode()) {
      LOGGER.error("Categories not found!");
    }
    return new CategoriesDTO();
  }

  @Override
  public SourcesDTO retrieveSources(ServiceInfo serviceInfo) {

    Client client = ClientBuilder.newClient();

    WebTarget webTarget = client.target(buildTarget(serviceInfo)).path("sources");

    Response response = webTarget.request(MediaType.APPLICATION_JSON).get();

    if (response.getStatus() == Status.OK.getStatusCode()) {
      SourcesDTO sourcesDTO = new SourcesDTO();
      SourcesModel sources = response.readEntity(SourcesModel.class);
      for (SourceModel source : sources.getSources()) {
        sourcesDTO
            .add(new SourceDTO(source.getId(), source.getDisplayName(), source.getDescription(), source.getImage()));

      }
      return sourcesDTO;
    }
    if (response.getStatus() == Status.NOT_FOUND.getStatusCode()) {
      // error logging
    }
    return new SourcesDTO();

  }
}
