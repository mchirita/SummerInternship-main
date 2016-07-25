package org.iqu.slaveservices.rest.consumer;

import java.util.Set;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.coreservices.config.ServiceInfo;
import org.iqu.slaveservices.entities.Event;
import org.iqu.slaveservices.entities.Source;
import org.iqu.slaveservices.entities.TypeService;

import orq.iqu.slaveservices.dto.AuthorsDTO;

public class EventsConsumerImpl implements EventsConsumer {

	@Override
	public AuthorsDTO retrieveAuthors(ServiceInfo serviceInfo) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(
				"http://" + serviceInfo.getHostname() + ":" + serviceInfo.getPort() + "/" + serviceInfo.getUrl())
				.path("authors");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		Authors authors = response.readEntity(Authors.class);

		// return authors;
		return new AuthorsDTO(authors.getAuthors());
	}

	@Override
	public Set<Event> retrieveEvents(ServiceInfo serviceInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Source> retrieveSources(ServiceInfo serviceInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<TypeService> retrieveTypes(ServiceInfo serviceInfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
