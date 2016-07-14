package org.iqu.webapp.news.categories;

import java.util.HashSet;
import java.util.Set;

/**
 * Categories - Class that represents a set of categories.
 * 
 * @author Alex Dragomir
 *
 */
public class Categories {

	private Set<String> categories = new HashSet<String>();

	public Categories(Set<String> categories) {
		super();
		this.categories = categories;
	}

	public Categories() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
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
		Categories other = (Categories) obj;
		if (categories == null) {
			if (other.categories != null)
				return false;
		} else if (!categories.equals(other.categories))
			return false;
		return true;
	}

	public Set<String> getCategories() {
		return categories;
	}

	public void setCategories(Set<String> categories) {
		this.categories = categories;
	}

	public boolean addCateg(String name) {
		return this.categories.add(name);
	}

	public boolean isEmpty() {
		return this.categories.isEmpty();
	}
}