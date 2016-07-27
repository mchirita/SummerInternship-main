package orq.iqu.slaveservices.others;

import java.util.List;

import org.iqu.slaveservices.rest.consumer.models.ClientModel;

public interface HealthCheckServiceSlave {

  List<ClientModel> heathCheck();
}
