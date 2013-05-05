package project;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Feed implements Comparable<Feed> {
	private String title;
	private Path path;
	private SimpleDateFormat pubDate;
	private List<Article> articles;
	
	public Feed(String title,SimpleDateFormat pubDate,String path,ArrayList<Article> articles){
		this.title=title;
		this.pubDate=pubDate;
		this.path = Paths.get(path, null);
		this.articles = articles;
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public Path getPath(){
		return path;
	}
	
	public void setPath(Path path){
		this.path = path;
	}
	
	public SimpleDateFormat getDate(){
		return pubDate;
	}
	
	public void setDate(SimpleDateFormat date){
		this.pubDate = date;
	}
	
	public String toString(){
		return "Feed Title: " + title + " Feed Path: " + path + " Feed date: " + pubDate;
	}
	//**Start From Here Next TIME**//
	@Override
	public int compareTo(Feed arg0) {
		return 0;
	}

//	public int compareTo(Feed feed) {
//		String othertitle = feed.title;
//		return title.compareTo(othertitle);
//	}
}
