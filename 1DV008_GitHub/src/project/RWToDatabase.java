 package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Kamyar_Aflaki Ali_Khalili Uraz_Seddigh 
 *
 */
public class RWToDatabase {
	private final static String url = "jdbc:mysql://localhost:3306/rssDB";
	private final static String user = "root";
	private final static String password = "";
	private static Connection connection = null;
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	private static PreparedStatement preparedStatement1 = null;
	private static PreparedStatement preparedStatement2 = null;
	private static PreparedStatement preparedStatement3 = null;
	private static PreparedStatement preparedStatement4 = null;
	private static ResultSet resultSet = null;
	private static int userID;
	private static List<String> categoryList;
	private static List<String> feedList;
	private static List<String> feedList2;
	private static int categoryID;
	private static int feedID;
	private static String feedPath;
	
	/**
	 * @param name Username.
	 * @return True if username exists.
	 */
	public static boolean nameExists(String name) {
		startConnection();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM rssDB.user;");
			while (resultSet.next()) {
				if (resultSet.getString("name").equals(name)) {
					closeConnection();
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return false;
	}
	
	/**
	 * @param name Username.
	 * @param password Password
	 * @return True if password matches, False if not.
	 */
	public static boolean passwordMatches(String name, String password) {
		startConnection();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM rssDB.user WHERE name = ?;");
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
//			System.out.println(password);
//			System.out.println(resultSet.getString("password"));
//			while (resultSet.next()) {
				if (resultSet.getString("password").equals(password)) {
					closeConnection();
					return true;
				}
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return false;
	}
	

	/**
	 * @param username Username.
	 * @return User's ID.
	 */
	public static int getUserID(String username) {
		startConnection();
		userID = 0;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM rssDB.user WHERE name = ?;");
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			userID = resultSet.getInt("id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return userID;
	}
	
	/**
	 * @param userID
	 * @return String array of user's category.
	 */
	public static String[] getUsersCategoryList(int userID) {
		startConnection();
		categoryList = new ArrayList<String>();
		String[] result = null;
		try {
			preparedStatement = connection.prepareStatement("SELECT name FROM rssDB.category WHERE id IN " +
					"(SELECT category_id FROM rssDB.user_defines_category WHERE user_id = ?);");
			preparedStatement.setInt(1, userID);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
				categoryList.add(resultSet.getString("name"));
			result = new String[categoryList.size()];
			categoryList.toArray(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return result;
	}
	
	/**
	 * @return String array of user's feed.
	 */
	public static String[] getFeedList() {
		startConnection();
		feedList2 = new ArrayList<String>();
		String[] result = null;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM rssDB.feed;");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
				feedList2.add(resultSet.getString("title"));
			result = new String[feedList2.size()];
			feedList2.toArray(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return result;
	}
	
	/**
	 * @param userID User's ID.
	 * @param categoryID Category's ID.
	 * @return ??
	 */
	public static String[] getCategorysFeedList(int userID, int categoryID) {
		startConnection();
		feedList = new ArrayList<String>();
		String[] result = null;
		try {
			preparedStatement = connection.prepareStatement("SELECT title FROM rssDB.feed WHERE id IN " +
					"(SELECT feed_id FROM rssDB.user_adds_feed_to_category WHERE (user_id = ? AND category_id = ?));");
			preparedStatement.setInt(1, userID);
			preparedStatement.setInt(2, categoryID);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
				feedList.add(resultSet.getString("title"));
			result = new String[feedList.size()];
			feedList.toArray(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return result;
	}
	
	/**
	 * @param categoryName Category name.
	 * @return Category's ID.
	 */
	public static int getCategoryID(String categoryName) {
		startConnection();
		categoryID = 0;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM rssDB.category WHERE name = ?;");
			preparedStatement.setString(1, categoryName);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			categoryID = resultSet.getInt("id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return categoryID;
	}
	
	/**
	 * @param categoryName category's name.
	 * @return ??
	 */
	private static int getCategoryIDPrivate(String categoryName) {
		categoryID = 0;
		try {
			preparedStatement1 = connection.prepareStatement("SELECT * FROM rssDB.category WHERE name = ?;");
			preparedStatement1.setString(1, categoryName);
			resultSet = preparedStatement1.executeQuery();
			resultSet.next();
			categoryID = resultSet.getInt("id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryID;
	}
	
	/**
	 * @param feedTitle Feed's title.
	 * @return Feed's ID.
	 */
	public static int getFeedID(String feedTitle) {
		startConnection();
		feedID = 0;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM rssDB.feed WHERE title = ?;");
			preparedStatement.setString(1, feedTitle);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			feedID = resultSet.getInt("id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return feedID;
	}
	
	/**
	 * @param feedTitle Feed's title.
	 * @return ??
	 */
	private static int getFeedIDPrivate(String feedTitle) {
		feedID = 0;
		try {
			preparedStatement4 = connection.prepareStatement("SELECT * FROM rssDB.feed WHERE title = ?;");
			preparedStatement4.setString(1, feedTitle);
			resultSet = preparedStatement4.executeQuery();
			resultSet.next();
			feedID = resultSet.getInt("id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return feedID;
	}
	
	/**
	 * @param categoryName Category's name.
	 * @param ownerID Owners ID.
	 * @return -1 if category exists, 1 if add is successful.
	 */
	public static int addCategory(String categoryName, int ownerID) {
		if (categoryExists(categoryName, ownerID))
			return -1;
		else {
			startConnection();
			try {
				preparedStatement = connection.prepareStatement("INSERT INTO rssDB.category(name) VALUES(?);");
				preparedStatement.setString(1, categoryName);
				preparedStatement.executeUpdate();
				preparedStatement2 = connection.prepareStatement("INSERT INTO rssDB.user_defines_category(user_id, category_id) VALUES(?, ?);");
				preparedStatement2.setInt(1, ownerID);
				preparedStatement2.setInt(2, getCategoryIDPrivate(categoryName));
				preparedStatement2.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeConnection();
			return 1;
		}
			
	}
	
	// Will be implemented in the future.
	public static void renameCategory(String oldCategoryName, String newCategoryName, int ownerID) {
		
	}
	
	/**
	 * @param categoryName Category's name.
	 * @param ownerID Owners ID.
	 */
	public static void removeCategory(String categoryName, int ownerID) {
		startConnection();
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM rssDB.user_defines_category WHERE (user_id = ?) AND (category_id = ?);");
			preparedStatement.setInt(1, ownerID);
			preparedStatement.setInt(2, getCategoryIDPrivate(categoryName));
			preparedStatement.executeUpdate();
			preparedStatement2 = connection.prepareStatement("DELETE FROM rssDB.user_adds_feed_to_category WHERE (user_id = ?) AND (category_id = ?);");
			preparedStatement2.setInt(1, ownerID);
			preparedStatement2.setInt(2, getCategoryIDPrivate(categoryName));
			preparedStatement2.executeUpdate();
			preparedStatement3 = connection.prepareStatement("DELETE FROM rssDB.category WHERE name = ?;");
			preparedStatement3.setString(1, categoryName);
			preparedStatement3.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
	}
	
	/**
	 * @param feedTitle Feed's title.
	 * @param belongingCategory ??
	 * @param ownerID Owners' ID.
	 */
	public static void addFeed(String feedTitle, String belongingCategory, int ownerID) {
		startConnection();
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO rssDB.user_adds_feed_to_category(user_id, feed_id, category_id) VALUES(?, ?, ?);");
			preparedStatement.setInt(1, ownerID);
			preparedStatement.setInt(2, getFeedIDPrivate(feedTitle));
			preparedStatement.setInt(3, getCategoryIDPrivate(belongingCategory));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
	}
	
	public static void removeFeed(String title, String belongingCategory, int owner) {
		
	}
	
	/**
	 * @param feedID Feed's ID.
	 * @return Feed's path.
	 */
	public static String getFeedPath(int feedID) {
		startConnection();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM rssDB.feed WHERE id = ?;");
			preparedStatement.setInt(1, feedID);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			feedPath = resultSet.getString("path");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return feedPath;
	}
	
	/**
	 * @param categoryName Category's name.
	 * @param ownerID Owners ID.
	 * @return True if category exists, False if not.
	 */
	public static boolean categoryExists(String categoryName, int ownerID) {
		if (Arrays.binarySearch(getUsersCategoryList(ownerID), categoryName) >= 0)
			return true;
		else
			return false;
	}
	
	/**
	 * @param feedTitle Feed's title.
	 * @param feedPath Feed's path.
	 */
	public static void fillFeedTable(String feedTitle, String feedPath) {
		startConnection();
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO rssDB.feed(title, path) Values(?, ?);");
			preparedStatement.setString(1, feedTitle);
			preparedStatement.setString(2, feedPath);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
	}
	
	private static void startConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void closeConnection() {
		try {
            if (resultSet != null)
            	resultSet.close();
            if (preparedStatement != null)
            	preparedStatement.close();
            if (preparedStatement2 != null)
            	preparedStatement2.close();
            if (preparedStatement3 != null)
            	preparedStatement3.close();
            if (connection != null)
            	connection.close();
        } catch (SQLException e) {
        	e.printStackTrace();
        }
	}

}
