package org.iqu.slaveservices.rest.consumer.models;

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
public class NewsModel {
  private Set<SingleNewsModel> news = new HashSet<SingleNewsModel>();

  public NewsModel() {
  }

  public NewsModel(Set<SingleNewsModel> news) {
    super();
    this.news = news;
  }

  @XmlElement
  public Set<SingleNewsModel> getNews() {
    return news;
  }

  public void setNews(Set<SingleNewsModel> news) {
    this.news = news;
  }

  public void add(SingleNewsModel singleNews) {
    news.add(singleNews);
  }

}
