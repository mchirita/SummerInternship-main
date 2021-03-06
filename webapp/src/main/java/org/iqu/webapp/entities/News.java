package org.iqu.webapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class that implements a set of news
 * 
 * @author iQuest
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class News {
  private Set<SingleNews> news = new HashSet<SingleNews>();

  public News() {
  }

  public News(Set<SingleNews> news) {
    super();
    this.news = news;
  }

  @XmlElement
  public Set<SingleNews> getNews() {
    return news;
  }

  public void setNews(Set<SingleNews> news) {
    this.news = news;
  }

  public void add(SingleNews singleNews) {
    news.add(singleNews);
  }

}
