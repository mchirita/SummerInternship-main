package org.iqu.webapp.entities;

public class Source {
	private String id;
	private String displayName;
	private String description;
<<<<<<< HEAD
	
	public Source(String id, String displayName, String description){
		this.id=id;
=======

	public Source(String id, String displayName, String description) {
		this.id = id;
>>>>>>> 6b4147add53bce5770592330835758606c8e4a87
		this.displayName = displayName;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Source [id=" + id + ", displayName=" + displayName + ", description=" + description + "]";
	}
<<<<<<< HEAD
	
}
=======

}
>>>>>>> 6b4147add53bce5770592330835758606c8e4a87
