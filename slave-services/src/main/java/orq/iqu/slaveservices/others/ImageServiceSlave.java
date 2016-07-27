package orq.iqu.slaveservices.others;

import orq.iqu.slaveservices.dto.ImageDTO;

public interface ImageServiceSlave {

  ImageDTO getImage(String imageId);

}
