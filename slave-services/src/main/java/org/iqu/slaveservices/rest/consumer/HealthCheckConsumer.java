package org.iqu.slaveservices.rest.consumer;

import java.util.Set;

import org.iqu.coreservices.config.ServiceInfo;

import orq.iqu.slaveservices.dto.ClientDTO;

public interface HealthCheckConsumer {

  Set<ClientDTO> getHealth(Set<ServiceInfo> servicesInfo);
}
