package org.iqu.slaveservices.rest.consumer.models;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Razvan Rosu
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TypesModel {
	private Set<TypeModel> types = new HashSet<TypeModel>();

	public TypesModel() {
	}

	public TypesModel(Set<TypeModel> types) {
		super();
		this.types = types;
	}

	@XmlElement
	public Set<TypeModel> getTypes() {
		return types;
	}

	public void setTypes(Set<TypeModel> types) {
		this.types = types;
	}

	public boolean isEmpty() {
		return types.isEmpty();
	}

	public void addType(TypeModel type) {
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
		TypesModel other = (TypesModel) obj;
		if (types == null) {
			if (other.types != null)
				return false;
		} else if (!types.equals(other.types))
			return false;
		return true;
	}

}
