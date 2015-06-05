package kdb.database;

import java.sql.Connection;
import java.sql.DriverManager;

public final class SQLiteDatabaseConnector {

	private static Connection c = null;

	/**
	 * Establishes a connection to the database that is specified by the given path.
	 * 
	 * @param path
	 *            Path to the file of the SQLite database file.
	 * @return if successful the connection to the database, else null
	 */
	public static Connection getConnection(String path) {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + path);
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			c = null;
		}
		return c;
	}

	/**
	 * Returns the last established connection. If the last attempt failed it returns null.
	 * 
	 * @return The last established connection, or null if the last try failed.
	 */
	public static Connection getLastConnection() {
		return c;
	}

}
