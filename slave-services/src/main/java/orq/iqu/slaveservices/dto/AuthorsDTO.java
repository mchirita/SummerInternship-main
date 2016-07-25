package orq.iqu.slaveservices.dto;

import java.util.HashSet;
import java.util.Set;

public class AuthorsDTO {

	private Set<String> authors = new HashSet<String>();

	public AuthorsDTO() {

	}

	public AuthorsDTO(Set<String> authors) {
		super();
		this.authors = authors;
	}

	public Set<String> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<String> authors) {
		this.authors = authors;
	}
}
