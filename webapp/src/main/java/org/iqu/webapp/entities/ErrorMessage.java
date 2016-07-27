package org.iqu.webapp.entities;

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
public class ErrorMessage {

	private String error;

	public ErrorMessage() {

	}

	public ErrorMessage(String error) {
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
