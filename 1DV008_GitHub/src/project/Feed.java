package project;

public class Feed implements Comparable<Feed> {
	private String title;
	private String path;
	private String pubDate;
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getPath(){
		return path;
	}
	
	public void setPath(String path){
		this.path = path;
	}
	
	public String getDate(){
		return pubDate;
	}
	
	public void setDate(String date){
		this.pubDate = date;
	}
	
	public String toString(){
		return "Feed Title: " + title + " Feed Path: " + path + " Feed date: " + pubDate;
	}

	public int compareTo(Feed feed) {
		String othertitle = feed.title;
		return title.compareTo(othertitle);
	}
}
