package org.iqu.slaveservices.rest.consumer;

import org.iqu.coreservices.config.ServiceInfo;

import orq.iqu.slaveservices.dto.AuthorsDTO;
import orq.iqu.slaveservices.dto.CategoriesDTO;
import orq.iqu.slaveservices.dto.NewsDTO;
import orq.iqu.slaveservices.dto.SourcesDTO;

public interface NewsConsumer {

  public NewsDTO retrieveNews(ServiceInfo serviceInfo);

  public AuthorsDTO retrieveAuthors(ServiceInfo serviceInfo);

  public CategoriesDTO retrieveCategories(ServiceInfo serviceInfo);

  public SourcesDTO retrieveSources(ServiceInfo serviceInfo);
}
