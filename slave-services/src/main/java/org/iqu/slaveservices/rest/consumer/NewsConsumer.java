package org.iqu.slaveservices.rest.consumer;

import java.util.Set;

import org.iqu.coreservices.config.ServiceInfo;
import org.iqu.slaveservices.entities.News;

import orq.iqu.slaveservices.dto.AuthorsDTO;
import orq.iqu.slaveservices.dto.CategoriesDTO;
import orq.iqu.slaveservices.dto.SourcesDTO;

public interface NewsConsumer {

	Set<News> retrieveNews(ServiceInfo serviceInfo);

	AuthorsDTO retrieveAuthors(ServiceInfo serviceInfo);

	CategoriesDTO retrieveCategories(ServiceInfo serviceInfo);

	SourcesDTO retrieveSources(ServiceInfo serviceInfo);
}
