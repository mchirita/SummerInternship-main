package org.iqu.webapp.entities;

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
public class Author {
	private String name;

	public Author() {

	}

	public Author(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "\"" + name + "\"";
	}

}
