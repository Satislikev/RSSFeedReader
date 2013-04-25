package project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserClass {

	String name;
	String password;
	String Categories;
	
	final List<Category> entries = new ArrayList<Category>();
	public void Feed(String name, String password){
		
		this.name = name;
		
		this.password = password;
	}
	
	public List<Category> getCategories(){
		return entries;
	}
		
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
		
	}	
		
		 public String toString() {
			    return "Categories [name=" + name + ", password=" + password + "]";	
			    
		 }
		
		 
public void add(String Categories, String title){
	
}


		 
public static void main(String[] args) {
				   
// Sort strings - or any other Comparable objects.
				   
String[] category = {"Categories"};
Arrays.sort(category);
System.out.println(Arrays.toString(category));
			    
			    
			    
			    
		
	}

	}


