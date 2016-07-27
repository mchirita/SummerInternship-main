package org.iqu.slaveservices.rest.consumer.models;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Client - Entity that represents a client.
 * 
 * @author Alex Dragomir
 *
 */
public class ClientModel {

	private String host, location;
	private int port;
	private boolean active;

	public ClientModel(String host, int port, String location, boolean active) {
		super();
		this.host = host;
		this.port = port;
		this.location = location;
		this.active = active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	@JsonValue
	public String toString() {
		return "Client [host=" + host + ", location=" + location + ", port=" + port + ", active=" + active + "]";
	}

}
