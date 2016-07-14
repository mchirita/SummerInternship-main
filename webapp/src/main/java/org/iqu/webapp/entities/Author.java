package org.iqu.webapp.entities;

/**
 * 
 * @author Beniamin Savu
 *
 * Entity that represents an author
 */
public class Author {
	private String name;
	
	public Author(String name){
		this.name = name;
	}

	@Override
	public String toString() {
		return "\"" + name + "\"";
	}
	
	
}
