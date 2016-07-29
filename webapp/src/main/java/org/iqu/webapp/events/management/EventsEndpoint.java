package org.iqu.webapp.events.management;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.iqu.webapp.entities.Authors;
import org.iqu.webapp.entities.ErrorMessage;
import org.iqu.webapp.entities.Event;
import org.iqu.webapp.entities.Events;
import org.iqu.webapp.entities.Source;
import org.iqu.webapp.entities.Sources;
import org.iqu.webapp.entities.Type;
import org.iqu.webapp.entities.Types;
import org.iqu.webapp.factory.ServiceFactory;
import org.iqu.webapp.filter.CORSResponse;
import org.iqu.webapp.filter.Secured;

import orq.iqu.slaveservices.dto.AuthorsDTO;
import orq.iqu.slaveservices.dto.EventDTO;
import orq.iqu.slaveservices.dto.EventsDTO;
import orq.iqu.slaveservices.dto.SourceDTO;
import orq.iqu.slaveservices.dto.SourcesDTO;
import orq.iqu.slaveservices.dto.TypeDTO;
import orq.iqu.slaveservices.dto.TypesDTO;
import orq.iqu.slaveservices.events.EventsServiceSlave;

/**
 * EventsEndpoint - Class that holds the services for events end-point.
 * 
 * @author Razvan Rosu
 *
 */
@Path("/")
public class EventsEndpoint {

  private Logger LOGGER = Logger.getLogger(EventsEndpoint.class);
  private EventsServiceSlave eventsService = ServiceFactory.getEventsServiceInstance();

  /**
   * Method that implements retrieve authors service.
   */
  @Path("/authors")
  @GET
  @Secured
  @CORSResponse
  @Produces(MediaType.APPLICATION_JSON)
  public Response retrieveAuthors() {

    AuthorsDTO retrieveAuthors = eventsService.retrieveAuthors();
    Authors authors = new Authors(retrieveAuthors.getAuthors());
    if (authors.isEmpty()) {
      ErrorMessage errorMessage = new ErrorMessage("Could not fetch authors, please try again later.");
      LOGGER.error(errorMessage.getMessage());
      return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
    }

    return Response.ok().entity(authors).build();

  }

  /**
   * Service that retrieve events based on filters
   */
  @Path("/")
  @GET
  @Secured
  @CORSResponse
  @Produces(MediaType.APPLICATION_JSON)
  public Response retriveEvents(@QueryParam("startDate") String startDate, @QueryParam("endDate") String endDate,
      @QueryParam("type") String type, @QueryParam("subtype") String subtype, @QueryParam("sourceId") String sourceId,
      @QueryParam("author") String author, @QueryParam("location") String location) {

    EventsDTO retrieveEvents = eventsService.retrieveEvents(startDate, endDate, type, subtype, sourceId, author,
        location);
    Events events = new Events();
    for (EventDTO eventDTO : retrieveEvents.getEvents()) {
      events.add(new Event(eventDTO.getStartDate(), eventDTO.getEndDate(), eventDTO.getId(), eventDTO.getTitle(),
          eventDTO.getSubtitle(), eventDTO.getDescription(), eventDTO.getType(), eventDTO.getSubtypes(),
          eventDTO.getSource(), eventDTO.getBody(), eventDTO.getImage_id(), eventDTO.getThumbnail_id(),
          eventDTO.getExternal_url(), eventDTO.getAuthor()));
    }
    if (startDate == null) {
      ErrorMessage errorMessage = new ErrorMessage("Start Date Not Found.");
      LOGGER.error(errorMessage.getMessage());
      return Response.status(Status.BAD_REQUEST).entity(errorMessage).build();
    } else {
      return Response.ok().entity(events).build();
    }
  }
  // TO DO : implement filter of data

  /**
   * This method returns a list of sources where we grab our content.
   */
  @Path("/sources")
  @GET
  @Secured
  @CORSResponse
  @Produces(MediaType.APPLICATION_JSON)
  public Response retrieveSource() {
    SourcesDTO retrieveSources = eventsService.retrieveSources();
    Sources sources = new Sources();
    for (SourceDTO sourceDTO : retrieveSources.getSources()) {
      sources.addSource(
          new Source(sourceDTO.getId(), sourceDTO.getDisplayName(), sourceDTO.getDescription(), sourceDTO.getImage()));
    }
    if (!sources.isEmpty()) {
      return Response.status(Status.OK).entity(sources).build();
    } else {
      ErrorMessage errorMessage = new ErrorMessage("Could not fetch sources, please try again later.");
      LOGGER.error(errorMessage.getMessage());
      return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
    }
  }

  /**
   * Thid method returns all types and subtypes of events.
   */
  @Path("/types")
  @GET
  @Secured
  @CORSResponse
  @Produces(MediaType.APPLICATION_JSON)
  public Response retriveTypes() {

    TypesDTO typesDTO = eventsService.retrieveTypes();
    Types types = new Types();
    for (TypeDTO type : typesDTO.getTypes()) {
      types.addType(new Type(type.getType(), type.getSubTypes()));
    }
    if (types.isEmpty()) {
      ErrorMessage errorMessage = new ErrorMessage("Could not fetch categories, please try again later.");
      LOGGER.error(errorMessage.getMessage());
      return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
    }

    return Response.status(Status.OK).entity(types).build();

  }
}
