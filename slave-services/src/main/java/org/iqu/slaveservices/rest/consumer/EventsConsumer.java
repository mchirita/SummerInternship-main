package org.iqu.slaveservices.rest.consumer;

import org.iqu.coreservices.config.ServiceInfo;

import orq.iqu.slaveservices.dto.AuthorsDTO;
import orq.iqu.slaveservices.dto.EventsDTO;
import orq.iqu.slaveservices.dto.SourcesDTO;
import orq.iqu.slaveservices.dto.TypesDTO;

public interface EventsConsumer {

	EventsDTO retrieveEvents(ServiceInfo serviceInfo);

	AuthorsDTO retrieveAuthors(ServiceInfo serviceInfo);

	TypesDTO retrieveTypes(ServiceInfo serviceInfo);

	SourcesDTO retrieveSources(ServiceInfo serviceInfo);

}
