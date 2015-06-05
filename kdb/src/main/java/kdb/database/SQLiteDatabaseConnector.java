package kdb.database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Class for a connection to a SQLite database.
 * 
 * @author Zarfius94
 * @version 1.0
 *
 */
public class SQLiteDatabaseConnector implements DatabaseConnector {

	private Connection c;
	private static SQLiteDatabaseConnector sig;

	private SQLiteDatabaseConnector() {
		c = null;
	}

	@Override
	public Connection getConnection(String path) {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + path);
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			c = null;
		}
		return c;
	}

	@Override
	public Connection getLastConnection() {
		return c;
	}

	public static SQLiteDatabaseConnector getInstance() {
		if (SQLiteDatabaseConnector.sig == null) {
			SQLiteDatabaseConnector.sig = new SQLiteDatabaseConnector();
		}
		return SQLiteDatabaseConnector.sig;
	}

}
