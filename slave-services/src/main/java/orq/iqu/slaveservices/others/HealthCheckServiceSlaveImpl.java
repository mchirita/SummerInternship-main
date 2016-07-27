package orq.iqu.slaveservices.others;

import java.util.ArrayList;
import java.util.List;

import org.iqu.slaveservices.rest.consumer.models.ClientModel;

public class HealthCheckServiceSlaveImpl implements HealthCheckServiceSlave {

	@Override
	public List<ClientModel> heathCheck() {

		List<ClientModel> clients = new ArrayList<ClientModel>();
		ClientModel client = new ClientModel("capp1.iquestgroup.com", 8080, "Cluj", true);
		ClientModel client1 = new ClientModel("capp2.iquestgroup.com", 8080, "Craiova", false);
		clients.add(client);
		clients.add(client1);

		return clients;
	}

}
