package org.iqu.slaveservices.rest.consumer.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ErrorMessage - Class that represents the error message.
 * 
 * @author Alex Dragomir
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorMessageModel {

	private String error;

	public ErrorMessageModel() {

	}

	public ErrorMessageModel(String error) {
		super();
		this.error = error;
	}

	public String getMessage() {
		return error;
	}

	public void setMessage(String error) {
		this.error = error;
	}

}
