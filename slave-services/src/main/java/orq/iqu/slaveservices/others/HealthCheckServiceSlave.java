package orq.iqu.slaveservices.others;

import java.util.List;

import org.iqu.slaveservices.entities.Client;

public interface HealthCheckServiceSlave {

	public List<Client> heathCheck();
}
