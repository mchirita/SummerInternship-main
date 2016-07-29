package orq.iqu.slaveservices.others;

import org.iqu.coreservices.config.ConfigServicesManager;
import org.iqu.coreservices.config.ServiceInfo;
import org.iqu.slaveservices.rest.consumer.factory.ConsumerFactory;

import orq.iqu.slaveservices.dto.ImageDTO;

public class ImageServiceSlaveImpl implements ImageServiceSlave {

  private ConfigServicesManager configServicesManager = ConfigServicesManager.getInstance();

  @Override
  public ImageDTO getImage(String imageId) {

    for (ServiceInfo serviceInfo : configServicesManager.getSlaveApps()) {
      ImageDTO imageDTO = ConsumerFactory.getImageConsumerInstance().retrieveImage(serviceInfo, imageId);
      if (imageDTO.getLink() != null) {
        return imageDTO;
      }
    }
    return new ImageDTO();
  }

}
