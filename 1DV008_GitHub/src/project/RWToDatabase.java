package project;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RWToDatabase {
	private final static String url = "jdbc:mysql://localhost:3306/rssDB";
	private final static String user = "root";
	private final static String password = "";
	private static Connection connection = null;
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
	
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
	
	public static void addCategory(String title, User owner) {
//		jhjh
	}
	
	public static void removeCategory(String title, User owner) {
		
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
