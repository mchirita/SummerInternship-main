package orq.iqu.slaveservices.dto;

import java.util.ArrayList;
import java.util.List;

public class TypeDTO {

  private String type;
  private List<String> subtypes = new ArrayList<String>();

  public TypeDTO() {

  }

  public TypeDTO(String nameOfType, List<String> subtypes) {
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

  public List<String> getSubTypes() {
    return subtypes;
  }

  public void setSubTypes(List<String> subtypes) {
    this.subtypes = subtypes;
  }

}
