package orq.iqu.slaveservices.dto;

import java.util.HashSet;
import java.util.Set;

public class SourcesDTO {

	private Set<SourceDTO> sources = new HashSet<SourceDTO>();

	public SourcesDTO() {

	}

	public SourcesDTO(Set<SourceDTO> sources) {
		super();
		this.sources = sources;
	}

	public Set<SourceDTO> getSources() {
		return sources;
	}

	public void setSources(Set<SourceDTO> sources) {
		this.sources = sources;
	}

	public boolean isEmpty() {
		return sources.isEmpty();
	}

	public void add(SourceDTO sourceDTO) {
		sources.add(sourceDTO);
	}

}
