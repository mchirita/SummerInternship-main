package orq.iqu.slaveservices.others;

import org.iqu.coreservices.config.ServiceInfo;
import org.iqu.slaveservices.rest.consumer.ImageConsumer;
import org.iqu.slaveservices.rest.consumer.factory.ConsumerFactory;

import orq.iqu.slaveservices.dto.ImageDTO;

public class ImageServiceSlaveImpl implements ImageServiceSlave {

  private ImageConsumer imageConsumerInstance = new ConsumerFactory().getImageConsumerInstance();

  @Override
  public ImageDTO getImage(String imageId) {
    return imageConsumerInstance
        .retrieveImage(new ServiceInfo("localhost", "8080", "web-crawler/images/{$" + imageId + "}"));
  }

}
