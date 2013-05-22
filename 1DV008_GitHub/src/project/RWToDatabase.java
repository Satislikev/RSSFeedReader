package project;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RWToDatabase {
	private final static String url = "jdbc:mysql://localhost:3306/rssDB";
	private final static String user = "root";
	private final static String password = "";
	private static Connection connection = null;
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
	private static int userID;
	private static List<String> categoryList;
	private static List<String> feedList;
	private static int categoryID;

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

	public static boolean passwordMatches(String name, String password) {
		startConnection();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM rssDB.user WHERE name = ?;");
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
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


	public static int getUserID(String username) {
		startConnection();
		userID = 0;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM rssDB.user WHERE name = ?;");
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			userID = resultSet.getInt("id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return userID;
	}

	public static String[] getUsersCategoryList(int userID) {
		startConnection();
		categoryList = new ArrayList<String>();
		String[] result = null;
		try {
			preparedStatement = connection.prepareStatement("SELECT name FROM rssDB.category WHERE id IN " +
					"(SELECT category_id FROM reeDB.user_defines_category WHERE user_id = ?);");
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

	public static String[] getCategorysFeedList(int userID, int categoryID) {
		startConnection();
		feedList = new ArrayList<String>();
		String[] result = null;
		try {
			preparedStatement = connection.prepareStatement("SELECT title FROM rssDB.feed WHERE id IN " +
					"(SELECT category_id FROM reeDB.user_defines_category WHERE user_id = ?);");
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

	public static int getCategoryID(String categoryName) {
		startConnection();
		categoryID = 0;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM rssDB.category WHERE name = ?;");
			preparedStatement.setString(1, categoryName);
			resultSet = preparedStatement.executeQuery();
			categoryID = resultSet.getInt("id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return categoryID;
	}

	public static void addCategory(String categoryName, int ownerID) {

	}

	public static void renameCategory(String oldCategoryName, String newCategoryName, int ownerID) {

	}

	public static void removeCategory(String categoryName, int ownerID) {

	}

	public static void addFeed(String title, Path path, Category belongingCategory, User owner) {

	}

	public static void removeFeed(String title, Category belongingCategory, User owner) {

	}

	private static void startConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
//
	private static void closeConnection() {
		try {
			if (resultSet != null)
				resultSet.close();
			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
