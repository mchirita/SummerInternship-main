package orq.iqu.slaveservices.dto;

import java.util.HashSet;
import java.util.Set;

public class NewsDTO {
	private Set<SingleNewsDTO> news = new HashSet<SingleNewsDTO>();

	public NewsDTO() {

	}

	public NewsDTO(Set<SingleNewsDTO> news) {
		super();
		this.news = news;
	}

	public Set<SingleNewsDTO> getNews() {
		return news;
	}

	public void setNews(Set<SingleNewsDTO> news) {
		this.news = news;
	}

	public void add(SingleNewsDTO singelNews) {
		news.add(singelNews);
	}

}
