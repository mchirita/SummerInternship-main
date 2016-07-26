package org.iqu.slaveservices.entities;

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
  private Set<NewsArticle> news = new HashSet<NewsArticle>();

  public News() {
  }

  public News(Set<NewsArticle> news) {
    super();
    this.news = news;
  }

  @XmlElement
  public Set<NewsArticle> getNews() {
    return news;
  }

  public void setNews(Set<NewsArticle> news) {
    this.news = news;
  }

  public void add(NewsArticle singleNews) {
    news.add(singleNews);
  }

}
