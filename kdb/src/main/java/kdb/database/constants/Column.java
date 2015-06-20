package kdb.database.constants;

public class Column {

	private String name;
	
	private String dbName;
	
	private DatabaseType type;
	
	private int size;
	/**
	 * A representation of a column in the database.
	 * @param name name for the program
	 * @param dbName name in the database
	 * @param type type of the column
	 * @param size size/length for the column
	 */
	public Column(String name, String dbName, DatabaseType type, int size){
		if(size < 1) {
		this.name = name;
		this.dbName = dbName;
		this.type = type;
		} else {
			throw new IllegalArgumentException("The size has to be bigger or even 1");
		}
	}

	/**
	 * Returns the name of the column
	 * @return column name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the name used in the database for the column
	 * @return the name used in the database
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * Type of the column
	 * @return the column type
	 */
	public DatabaseType getType() {
		return type;
	}

	/**
	 * Size/Length of the column
	 * @return the size/length for the column
	 */
	public int getSize() {
		return size;
	}
}
