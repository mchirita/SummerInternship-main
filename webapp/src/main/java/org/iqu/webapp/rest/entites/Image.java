package org.iqu.webapp.rest.entites;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Image - Class that represents an image.
 * 
 * @author Alex Dragomir
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Image {

  private String link;

  public Image() {

  }

  public Image(String link) {
    super();
    this.link = link;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

}
