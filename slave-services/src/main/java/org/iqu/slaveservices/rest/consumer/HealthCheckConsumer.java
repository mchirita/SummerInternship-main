package org.iqu.slaveservices.rest.consumer;

import java.util.List;

import org.iqu.coreservices.config.ServiceInfo;
import org.iqu.slaveservices.entities.Client;

public interface HealthCheckConsumer {

	List<Client> getHealth(ServiceInfo serviceInfo);
}
