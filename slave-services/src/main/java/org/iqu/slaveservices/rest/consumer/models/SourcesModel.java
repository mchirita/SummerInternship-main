package org.iqu.slaveservices.rest.consumer.models;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SourcesModel {
	private Set<SourceModel> sources = new HashSet<SourceModel>();

	public SourcesModel() {
	}

	public SourcesModel(Set<SourceModel> sources) {
		super();
		this.sources = sources;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sources == null) ? 0 : sources.hashCode());
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
		SourcesModel other = (SourcesModel) obj;
		if (sources == null) {
			if (other.sources != null)
				return false;
		} else if (!sources.equals(other.sources))
			return false;
		return true;
	}

	@XmlElement
	public Set<SourceModel> getSources() {
		return sources;
	}

	public void setSources(Set<SourceModel> sources) {
		this.sources = sources;
	}

	public boolean addSource(SourceModel source) {
		return sources.add(source);
	}

	public boolean isEmpty() {
		return sources.isEmpty();
	}

	public int size() {
		return sources.size();
	}

}
