package project;

public class Article {
	
		String title;
		String description;
		String author;
		
		
		public String getTitle(){
			return title;
		}
		
		public void setTitle(String title){
			this.title = title;
		}
		
		public String getDescription(){
			return description;
		}
		
		public void setDescription(String description){
			this.description = description;
		}
		
		
		public String getAuthor(){
			return author;
		}
		
		public void setAuthor(String author){
			this.author = author;
		}
		
		
		public String toString(){
			return "ArticleClass[title=" + title + ", description=" + description + ", author=" + author+" ]";	

	}

}