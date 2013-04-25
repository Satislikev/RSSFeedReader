package project;

import java.util.ArrayList;


public class Category {
	public ArrayList<Feed> feeds = new ArrayList<Feed>();
	
	
	public void addFeed(Feed feed){
		feeds.add(feed);
	}
	
	public void removeFeed(Feed feed){
		feeds.remove(feed);
	}
	
	public void sortFeeds(){
		Feed a;
		for (int i = 1; i < feeds.size(); i++) {
			for(int j = i; j>0; j--){
				if(feeds.get(j).compareTo(feeds.get(j-1))<0){
					a = feeds.get(j-1);
					 list.get(j);//I have separated the equation into two parts if you can see below!
					 
					feeds.get(j-1);
					feeds.get(j);
				}
			}
		}
	}
}
