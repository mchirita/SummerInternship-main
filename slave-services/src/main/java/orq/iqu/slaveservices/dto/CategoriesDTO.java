package orq.iqu.slaveservices.dto;

import java.util.HashSet;
import java.util.Set;

public class CategoriesDTO {
	private Set<String> categories = new HashSet<String>();

	public CategoriesDTO() {
	}

	public CategoriesDTO(Set<String> categories) {
		super();
		this.categories = categories;
	}

	public Set<String> getCategories() {
		return categories;
	}

	public void setCategories(Set<String> categories) {
		this.categories = categories;
	}

	public boolean isEmpty() {
		return categories.isEmpty();
	}
}
