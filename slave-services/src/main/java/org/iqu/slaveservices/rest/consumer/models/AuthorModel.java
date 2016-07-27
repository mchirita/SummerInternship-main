package org.iqu.slaveservices.rest.consumer.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Beniamin Savu
 *
 *         Entity that represents an author
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AuthorModel {
	private String name;

	public AuthorModel() {

	}

	public AuthorModel(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "\"" + name + "\"";
	}

}
