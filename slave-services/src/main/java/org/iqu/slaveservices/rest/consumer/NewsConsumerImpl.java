package org.iqu.slaveservices.rest.consumer;

import java.util.Set;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.coreservices.config.ServiceInfo;
import org.iqu.slaveservices.entities.News;
import org.iqu.slaveservices.entities.Source;

import orq.iqu.slaveservices.dto.AuthorsDTO;
import orq.iqu.slaveservices.dto.CategoriesDTO;

public class NewsConsumerImpl implements NewsConsumer {

	@Override
	public Set<News> retrieveNews(ServiceInfo serviceInfo) {

		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(
				"http://" + serviceInfo.getHostname() + ":" + serviceInfo.getPort() + "/" + serviceInfo.getUrl())
				.path("news");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		return response.readEntity(new GenericType<Set<News>>() {
		});
	}

	@Override
	public AuthorsDTO retrieveAuthors(ServiceInfo serviceInfo) {

		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(
				"http://" + serviceInfo.getHostname() + ":" + serviceInfo.getPort() + "/" + serviceInfo.getUrl())
				.path("authors");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		if (response.getStatus() == 200) {
			Authors authors = response.readEntity(Authors.class);
			return new AuthorsDTO(authors.getAuthors());
		}
		if (response.getStatus() == 404) {
			// error logging
		}
		return new AuthorsDTO();
	}

	@Override
	public CategoriesDTO retrieveCategories(ServiceInfo serviceInfo) {

		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(
				"http://" + serviceInfo.getHostname() + ":" + serviceInfo.getPort() + "/" + serviceInfo.getUrl())
				.path("categories");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		if (response.getStatus() == 200) {
			Categories categories = response.readEntity(Categories.class);
			return new CategoriesDTO(categories.getCategories());
		}
		if (response.getStatus() == 404) {
			// error logging
		}
		return new CategoriesDTO();
	}

	@Override
	public Set<Source> retrieveSources(ServiceInfo serviceInfo) {

		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(
				"http://" + serviceInfo.getHostname() + ":" + serviceInfo.getPort() + "/" + serviceInfo.getUrl())
				.path("sources");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		return response.readEntity(new GenericType<Set<Source>>() {
		});

	}
}
