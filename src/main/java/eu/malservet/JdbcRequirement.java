package eu.malservet;

import java.io.File;
import java.net.URL;

/**
 * class to check a requirement of type jdbc
 * 
 * @author nicol
 *
 */
public class JdbcRequirement extends Requirement {

	private String driver;

	private String url;

	private String port;

	private String login;

	private String password;

	@Override
	public boolean check() {
		boolean result = false;
		// check if all the properties are setted
		for (Property property : properties) {
			if (property.type == Property.PropertyType.JDBC_URL) {
				driver = property.getValue();
			}
			if (property.type == Property.PropertyType.JDBC_URL) {
				url = property.getValue();
			}
			if (property.type == Property.PropertyType.LOGIN) {
				login = property.getValue();
			}
			if (property.type == Property.PropertyType.PASSWORD) {
				password = property.getValue();
			}
		}
		// test the connection
		try{
			//TODO implement here a generic jdbc connection
		}catch(Exception ex){
			
		}
		return result;
	}

}
