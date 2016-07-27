package org.iqu.webapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Razvan Rosu
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Type {

  private String type;
  private Set<String> subtypes = new HashSet<String>();

  public Type() {

  }

  public Type(String nameOfType, Set<String> subtypes) {
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