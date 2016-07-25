package orq.iqu.slaveservices.dto;

import java.util.HashSet;
import java.util.Set;

public class TypesDTO {
	private Set<TypeDTO> types = new HashSet<TypeDTO>();

	public TypesDTO() {
	}

	public TypesDTO(Set<TypeDTO> types) {
		super();
		this.types = types;
	}

	public Set<TypeDTO> getTypes() {
		return types;
	}

	public void setTypes(Set<TypeDTO> types) {
		this.types = types;
	}

	public boolean isEmpty() {
		return types.isEmpty();
	}

	public void addType(TypeDTO type) {
		types.add(type);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((types == null) ? 0 : types.hashCode());
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
		TypesDTO other = (TypesDTO) obj;
		if (types == null) {
			if (other.types != null)
				return false;
		} else if (!types.equals(other.types))
			return false;
		return true;
	}

}
