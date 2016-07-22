package org.iqu.slaveservices.rest.consumer;

import java.util.Set;

import org.iqu.coreservices.config.ServiceInfo;
import org.iqu.slaveservices.entities.Authors;
import org.iqu.slaveservices.entities.Categories;
import org.iqu.slaveservices.entities.News;
import org.iqu.slaveservices.entities.Source;

public interface NewsConsumer {

	Set<News> retrieveNews(ServiceInfo serviceInfo);

	Authors retrieveAuthors(ServiceInfo serviceInfo);

	Categories retrieveCategories(ServiceInfo serviceInfo);

	Set<Source> retrieveSources(ServiceInfo serviceInfo);
}
