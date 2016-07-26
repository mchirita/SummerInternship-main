package org.iqu.slaveservices.rest.consumer;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Razvan Rosu
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Type {

	private String type;
	private Set<String> subTypes = new HashSet<String>();

	public Type() {

	}

	public Type(String type, Set<String> subTypes) {
		super();
		this.type = type;
		this.subTypes = subTypes;
	}

	public String getType() {
		return type;
	}

	public void setNameOfType(String nameOfType) {
		this.type = nameOfType;
	}

	public Set<String> getSubTypes() {
		return subTypes;
	}

	public void setSubTypes(Set<String> subTypes) {
		this.subTypes = subTypes;
	}

}
