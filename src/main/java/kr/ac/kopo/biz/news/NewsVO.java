package kr.ac.kopo.biz.news;

import java.util.List;

public class NewsVO {
	private String lastBuildDate;
	private String total;
	private String start;
	private String display;
	private List<NewsItem> items;
	
	public String getLastBuildDate() {
		return lastBuildDate;
	}
	public void setLastBuildDate(String lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public List<NewsItem> getItems() {
		return items;
	}
	public void setItems(List<NewsItem> items) {
		this.items = items;
	}
	public NewsVO(String lastBuildDate, String total, String start, String display, List<NewsItem> items) {
		super();
		this.lastBuildDate = lastBuildDate;
		this.total = total;
		this.start = start;
		this.display = display;
		this.items = items;
	}
	public NewsVO() {
		super();
	}
	@Override
	public String toString() {
		return "NewsVO [lastBuildDate=" + lastBuildDate + ", total=" + total + ", start=" + start + ", display="
				+ display + "]";
	}
	
	
	

}
