package orq.iqu.slaveservices.others;

import org.iqu.coreservices.config.ServiceInfo;
import org.iqu.slaveservices.rest.consumer.factory.ConsumerFactory;

import orq.iqu.slaveservices.dto.ImageDTO;

public class ImageServiceSlaveImpl implements ImageServiceSlave {

  @Override
  public ImageDTO getImage(String imageId) {
    return ConsumerFactory.getImageConsumerInstance()
        .retrieveImage(new ServiceInfo("localhost", "8080", "web-crawler/images/{$" + imageId + "}"));
  }

}
