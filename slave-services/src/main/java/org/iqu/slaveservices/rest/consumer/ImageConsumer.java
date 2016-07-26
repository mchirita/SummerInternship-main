package org.iqu.slaveservices.rest.consumer;

import org.iqu.coreservices.config.ServiceInfo;

import orq.iqu.slaveservices.dto.ImageDTO;

public interface ImageConsumer {

  public ImageDTO retrieveImage(ServiceInfo serviceInfo);

}