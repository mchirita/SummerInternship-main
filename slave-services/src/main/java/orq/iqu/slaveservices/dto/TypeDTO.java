package orq.iqu.slaveservices.dto;

import java.util.HashSet;
import java.util.Set;

public class TypeDTO {

	private String type;
	private Set<String> subtypes = new HashSet<String>();

	public TypeDTO() {

	}

	public TypeDTO(String nameOfType, Set<String> subtypes) {
		super();
		this.type = nameOfType;
		this.subtypes = subtypes;
	}

	public String getType() {
		return type;
	}

	public void setNameOfType(String nameOfType) {
		this.type = nameOfType;
	}

	public Set<String> getSubTypes() {
		return subtypes;
	}

	public void setSubTypes(Set<String> subtypes) {
		this.subtypes = subtypes;
	}

}
