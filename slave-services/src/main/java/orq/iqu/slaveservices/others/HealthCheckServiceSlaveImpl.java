package orq.iqu.slaveservices.others;

import java.util.ArrayList;
import java.util.List;

import org.iqu.slaveservices.entities.Client;

public class HealthCheckServiceSlaveImpl implements HealthCheckServiceSlave {

	@Override
	public List<Client> heathCheck() {

		List<Client> clients = new ArrayList<Client>();
		Client client = new Client("capp1.iquestgroup.com", 8080, "Cluj", true);
		Client client1 = new Client("capp2.iquestgroup.com", 8080, "Craiova", false);
		clients.add(client);
		clients.add(client1);

		return clients;
	}

}
