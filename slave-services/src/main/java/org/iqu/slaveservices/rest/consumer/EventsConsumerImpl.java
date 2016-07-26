package org.iqu.slaveservices.rest.consumer;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.coreservices.config.ServiceInfo;
import org.iqu.slaveservices.entities.Event;

import orq.iqu.slaveservices.dto.AuthorsDTO;
import orq.iqu.slaveservices.dto.EventDTO;
import orq.iqu.slaveservices.dto.EventsDTO;
import orq.iqu.slaveservices.dto.SourceDTO;
import orq.iqu.slaveservices.dto.SourcesDTO;
import orq.iqu.slaveservices.dto.TypeDTO;
import orq.iqu.slaveservices.dto.TypesDTO;

public class EventsConsumerImpl implements EventsConsumer {

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
      // error logging
    }
    return new AuthorsDTO();
  }

  @Override
  public EventsDTO retrieveEvents(ServiceInfo serviceInfo) {
    Client client = ClientBuilder.newClient();

    WebTarget webTarget = client
        .target("http://" + serviceInfo.getHostname() + ":" + serviceInfo.getPort() + "/" + serviceInfo.getUrl())
        .path("events");

    Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
    Response response = invocationBuilder.get();

    if (response.getStatus() == 200) {
      Events events = response.readEntity(Events.class);
      EventsDTO eventsDTO = new EventsDTO();
      for (Event event : events.getEvents()) {
        eventsDTO.add(new EventDTO(event.getStartDate(), event.getEndDate(), event.getId(), event.getTitle(),
            event.getSubtitle(), event.getDescription(), event.getType(), event.getSubtypes(), event.getSource(),
            event.getBody(), event.getImage_id(), event.getThumbnail_id(), event.getExternal_url(), event.getAuthor()));

      }
      return eventsDTO;
    }
    if (response.getStatus() == 404) {
      // error logging
    }
    return new EventsDTO();
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
        sourcesDTO.add(new SourceDTO(source.getId(), source.getDisplayName(), source.getDescription()));

      }
      return sourcesDTO;
    }
    if (response.getStatus() == 404) {
      // error logging
    }
    return new SourcesDTO();

  }

  @Override
  public TypesDTO retrieveTypes(ServiceInfo serviceInfo) {
    Client client = ClientBuilder.newClient();

    WebTarget webTarget = client
        .target("http://" + serviceInfo.getHostname() + ":" + serviceInfo.getPort() + "/" + serviceInfo.getUrl())
        .path("types");
    Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
    Response response = invocationBuilder.get();

    if (response.getStatus() == 200) {
      Types types = response.readEntity(Types.class);
      TypesDTO typesDTO = new TypesDTO();
      for (Type type : types.getTypes()) {
        typesDTO.addType(new TypeDTO(type.getType(), type.getSubTypes()));
      }
      return typesDTO;
    }
    if (response.getStatus() == 404) {
      // error logging
    }
    return new TypesDTO();
  }

}
