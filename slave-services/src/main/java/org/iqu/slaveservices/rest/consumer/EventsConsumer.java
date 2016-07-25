package org.iqu.slaveservices.rest.consumer;

import java.util.Set;

import org.iqu.coreservices.config.ServiceInfo;
import org.iqu.slaveservices.entities.Event;
import org.iqu.slaveservices.entities.Source;
import org.iqu.slaveservices.entities.TypeService;

import orq.iqu.slaveservices.dto.AuthorsDTO;

public interface EventsConsumer {

	AuthorsDTO retrieveAuthors(ServiceInfo serviceInfo);

	Set<Event> retrieveEvents(ServiceInfo serviceInfo);

	Set<Source> retrieveSources(ServiceInfo serviceInfo);

	Set<TypeService> retrieveTypes(ServiceInfo serviceInfo);

}
