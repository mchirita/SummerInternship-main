package orq.iqu.slaveservices.others;

import java.util.List;

import org.iqu.slaveservices.rest.consumer.models.ClientModel;

public interface HealthCheckServiceSlave {

	public List<ClientModel> heathCheck();
}
