 package project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Kamyar Aflaki, Ali Khalili Uraz Seddigh
 * 
 */
public class User {
	private String name;
	private String password;
	private List<Category> categories;

	/**
	 * @param name UserName to be set.
	 * @param password Password to be set.
	 */
	public User(String name, String password) {
		this.name = name;
		this.password = password;
		categories = new ArrayList<Category>();
	}

	/**
	 * @param password Password of the username to check.
	 * @return True if credential are correct and False if not correct.
	 */
	public static boolean checkCredentials(String name, String password) {
		if (RWToDatabase.passwordMatches(name, password))
			return true;
		else
			return false;
	}

	/**
	 * @param category Category that should be added.
	 */
	public void addCategory(Category category) {
		categories.add(category);
		sortCategories();
	}

	/**
	 * @param category Category that should be removed.
	 */
	public void removeCategory(Category category) {
		if (hasCategory(category)) {
			categories.remove(category);
			sortCategories();
		} else {
			System.out.println("Category does not exist.");
		}
	}

	/**
	 * @param category Category that should checked.
	 * @return True if the category exists and False if not exist.
	 */
	public boolean hasCategory(Category category) {
		if (categories.contains(category))
			return true;
		else
			return false;

	}

	public void sortCategories() {
		Collections.sort(categories);
	}

	/**
	 * @return Username.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name New username that should be set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Password.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * @param password New Password that should be set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
