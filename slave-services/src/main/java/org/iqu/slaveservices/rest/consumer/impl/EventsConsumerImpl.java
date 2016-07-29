package org.iqu.slaveservices.rest.consumer.impl;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.iqu.coreservices.config.ServiceInfo;
import org.iqu.slaveservices.rest.consumer.BaseConsumer;
import org.iqu.slaveservices.rest.consumer.EventsConsumer;
import org.iqu.slaveservices.rest.consumer.models.AuthorsModel;
import org.iqu.slaveservices.rest.consumer.models.EventModel;
import org.iqu.slaveservices.rest.consumer.models.EventsModel;
import org.iqu.slaveservices.rest.consumer.models.SourceModel;
import org.iqu.slaveservices.rest.consumer.models.SourcesModel;
import org.iqu.slaveservices.rest.consumer.models.TypeModel;
import org.iqu.slaveservices.rest.consumer.models.TypesModel;

import orq.iqu.slaveservices.dto.AuthorsDTO;
import orq.iqu.slaveservices.dto.EventDTO;
import orq.iqu.slaveservices.dto.EventsDTO;
import orq.iqu.slaveservices.dto.SourceDTO;
import orq.iqu.slaveservices.dto.SourcesDTO;
import orq.iqu.slaveservices.dto.TypeDTO;
import orq.iqu.slaveservices.dto.TypesDTO;

public class EventsConsumerImpl extends BaseConsumer implements EventsConsumer {

  private static final String API_PATH = "events";

  @Override
  public AuthorsDTO retrieveAuthors(ServiceInfo serviceInfo) {
    Client client = ClientBuilder.newClient();

    WebTarget webTarget = client.target(buildTarget(serviceInfo, API_PATH)).path("authors");
    Response response = webTarget.request(MediaType.APPLICATION_JSON).get();

    if (response.getStatus() == Status.OK.getStatusCode()) {
      AuthorsModel authors = response.readEntity(AuthorsModel.class);
      return new AuthorsDTO(authors.getAuthors());
    }
    if (response.getStatus() == Status.NOT_FOUND.getStatusCode()) {
      // error logging
    }
    return new AuthorsDTO();
  }

  @Override
  public EventsDTO retrieveEvents(ServiceInfo serviceInfo, String urlQueryParam) {
    Client client = ClientBuilder.newClient();

    WebTarget webTarget = client.target(buildTarget(serviceInfo, API_PATH) + urlQueryParam);
    Response response = webTarget.request(MediaType.APPLICATION_JSON).get();

    if (response.getStatus() == Status.OK.getStatusCode()) {
      EventsModel events = response.readEntity(EventsModel.class);
      EventsDTO eventsDTO = new EventsDTO();
      for (EventModel event : events.getEvents()) {
        eventsDTO.add(new EventDTO(event.getStartDate(), event.getEndDate(), event.getId(), event.getTitle(),
            event.getSubtitle(), event.getDescription(), event.getType(), event.getSubtypes(), event.getSource(),
            event.getBody(), event.getImage_id(), event.getThumbnail_id(), event.getExternal_url(), event.getAuthor()));

      }
      return eventsDTO;
    }
    if (response.getStatus() == Status.NOT_FOUND.getStatusCode()) {
      // error logging
    }
    return new EventsDTO();
  }

  @Override
  public SourcesDTO retrieveSources(ServiceInfo serviceInfo) {
    Client client = ClientBuilder.newClient();

    WebTarget webTarget = client.target(buildTarget(serviceInfo, API_PATH)).path("sources");
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

  @Override
  public TypesDTO retrieveTypes(ServiceInfo serviceInfo) {
    Client client = ClientBuilder.newClient();

    WebTarget webTarget = client.target(buildTarget(serviceInfo, API_PATH)).path("types");
    Response response = webTarget.request(MediaType.APPLICATION_JSON).get();

    if (response.getStatus() == Status.OK.getStatusCode()) {
      TypesModel types = response.readEntity(TypesModel.class);
      TypesDTO typesDTO = new TypesDTO();
      for (TypeModel type : types.getTypes()) {
        typesDTO.addType(new TypeDTO(type.getType(), type.getSubTypes()));
      }
      return typesDTO;
    }
    if (response.getStatus() == Response.Status.NOT_FOUND.getStatusCode()) {
      // error logging
    }
    return new TypesDTO();
  }

}
