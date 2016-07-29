package org.iqu.slaveservices.rest.consumer;

import org.iqu.coreservices.config.ServiceInfo;

public abstract class BaseConsumer {

  private static final String HTTP_SCHEMA = "http://";
  private static final String COLON = ":";
  private static final String DASH = "/";

  protected String buildTarget(ServiceInfo serviceInfo, String apiPath) {
    StringBuilder targetBuilder = new StringBuilder();
    targetBuilder.append(HTTP_SCHEMA).append(serviceInfo.getHostname()).append(COLON).append(serviceInfo.getPort())
        .append(DASH).append(serviceInfo.getWebapp()).append(DASH).append(apiPath);
    return targetBuilder.toString();
  }

}
