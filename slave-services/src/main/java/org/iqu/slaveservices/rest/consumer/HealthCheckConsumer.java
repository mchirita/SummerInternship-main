package org.iqu.slaveservices.rest.consumer;

import java.util.List;

import org.iqu.coreservices.config.ServiceInfo;
import org.iqu.slaveservices.rest.consumer.models.ClientModel;

public interface HealthCheckConsumer {

	List<ClientModel> getHealth(ServiceInfo serviceInfo);
}
