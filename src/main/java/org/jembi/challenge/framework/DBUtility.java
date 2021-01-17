package org.jembi.challenge.framework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for the DB ChallengeApp
 * 
 * @author Gautchi R. Chambe (chambegautchi@gmail.com)
 */
public class DBUtility {

	private static DBUtility instance;

	private final static String IN_MEMORY_SQLITE = "jdbc:sqlite::memory:";

	private Connection connection;

	public DBUtility(String url) throws SQLException {
		connection = DriverManager.getConnection(url);
	}

	public static DBUtility getInstance() throws SQLException {

		return instance == null ? new DBUtility(IN_MEMORY_SQLITE) : instance;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}