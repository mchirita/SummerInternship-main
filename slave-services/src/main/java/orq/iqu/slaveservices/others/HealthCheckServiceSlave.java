package orq.iqu.slaveservices.others;

import java.util.Set;

import orq.iqu.slaveservices.dto.ClientDTO;

public interface HealthCheckServiceSlave {

  Set<ClientDTO> heathCheck();
}
