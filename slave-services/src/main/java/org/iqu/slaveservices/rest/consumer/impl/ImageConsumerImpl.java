package org.iqu.slaveservices.rest.consumer.impl;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.iqu.coreservices.config.ServiceInfo;
import org.iqu.slaveservices.rest.consumer.BaseConsumer;
import org.iqu.slaveservices.rest.consumer.Image;
import org.iqu.slaveservices.rest.consumer.ImageConsumer;

import orq.iqu.slaveservices.dto.ImageDTO;

public class ImageConsumerImpl extends BaseConsumer implements ImageConsumer {

  private static final Logger LOGGER = Logger.getLogger(NewsConsumerImpl.class);
  private static final String API_PATH = "images/";

  @Override
  public ImageDTO retrieveImage(ServiceInfo serviceInfo, String imageId) {

    Client client = ClientBuilder.newClient();

    WebTarget webTarget = client.target(buildTarget(serviceInfo, API_PATH) + imageId);

    Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
    Response response = invocationBuilder.get();

    if (response.getStatus() == Status.OK.getStatusCode()) {
      Image image = response.readEntity(Image.class);
      return new ImageDTO(image.getLink());
    }
    if (response.getStatus() == Status.NOT_FOUND.getStatusCode()) {
      LOGGER.error("Authors not found!");
    }
    return new ImageDTO();
  }

}
