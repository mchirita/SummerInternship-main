package orq.iqu.slaveservices.others;

import java.util.HashSet;
import java.util.Set;

import org.iqu.coreservices.config.ConfigServicesManager;
import org.iqu.slaveservices.rest.consumer.factory.ConsumerFactory;

import orq.iqu.slaveservices.dto.ClientDTO;

public class HealthCheckServiceSlaveImpl implements HealthCheckServiceSlave {
  private ConfigServicesManager configServicesManager = ConfigServicesManager.getInstance();

  @Override
  public Set<ClientDTO> heathCheck() {
    Set<ClientDTO> clientDTOSet = new HashSet<ClientDTO>();

    clientDTOSet = ConsumerFactory.getHealthCheckConsumerInstance().getHealth(configServicesManager.getSlaveApps());

    return clientDTOSet;
  }

}
