package org.iqu.slaveservices.rest.consumer.models;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Categories - Class that represents a set of authors.
 * 
 * @author Alex Dragomir
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AuthorsModel {

	private Set<String> authors = new HashSet<String>();

	public AuthorsModel() {

	}

	public AuthorsModel(Set<String> authors) {
		super();
		this.authors = authors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthorsModel other = (AuthorsModel) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		return true;
	}

	@XmlElement
	public Set<String> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<String> authors) {
		this.authors = authors;
	}

	public boolean addAuthor(String name) {
		return this.authors.add(name);
	}

	public boolean isEmpty() {
		return this.authors.isEmpty();
	}

	public int size() {
		return authors.size();
	}
}
