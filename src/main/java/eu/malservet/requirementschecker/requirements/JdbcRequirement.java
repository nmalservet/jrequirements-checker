package eu.malservet.requirementschecker;

/**
 * class to check a requirement of type jdbc
 * 
 * @author nicolas malservet
 *
 */
public class JdbcRequirement extends Requirement {

	/**
	 * connection string :
	 * examples : 
	 * mysql : 
	 * oracle :
	 * postgresql :
	 * mongodb : 
	 * 
	 */
	public String connectionString;

	public String jdbcDriver;

	public JdbcRequirement(String connectionString, String jdbcDriver) {
		this.connectionString = connectionString;
		this.jdbcDriver = jdbcDriver;
	}

	@Override
	public boolean check() {
		boolean result = false;
		// check if the jdbc  library is present
		System.out.println("no jdbc connection");	
		// test the connection
		try {
			// TODO implement here a generic jdbc connection
		} catch (Exception ex) {

		}
		return result;
	}

}
