package org.iqu.slaveservices.rest.consumer;

import org.iqu.coreservices.config.ServiceInfo;

import orq.iqu.slaveservices.dto.AuthorsDTO;
import orq.iqu.slaveservices.dto.CategoriesDTO;
import orq.iqu.slaveservices.dto.NewsDTO;
import orq.iqu.slaveservices.dto.SourcesDTO;

public interface NewsConsumer {

  NewsDTO retrieveNews(ServiceInfo serviceInfo);

  AuthorsDTO retrieveAuthors(ServiceInfo serviceInfo);

  CategoriesDTO retrieveCategories(ServiceInfo serviceInfo);

  SourcesDTO retrieveSources(ServiceInfo serviceInfo);
}
