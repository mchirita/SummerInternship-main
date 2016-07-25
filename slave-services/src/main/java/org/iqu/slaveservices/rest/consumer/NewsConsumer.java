package org.iqu.slaveservices.rest.consumer;

import java.util.Set;

import org.iqu.coreservices.config.ServiceInfo;
import org.iqu.slaveservices.entities.News;
import org.iqu.slaveservices.entities.Source;

import orq.iqu.slaveservices.dto.AuthorsDTO;
import orq.iqu.slaveservices.dto.CategoriesDTO;

public interface NewsConsumer {

	Set<News> retrieveNews(ServiceInfo serviceInfo);

	AuthorsDTO retrieveAuthors(ServiceInfo serviceInfo);

	CategoriesDTO retrieveCategories(ServiceInfo serviceInfo);

	Set<Source> retrieveSources(ServiceInfo serviceInfo);
}
