package eu.malservet.requirementschecker.loader;

/**
 * class to represent a property, used into a requirement.
 * @author nicol
 *
 */
public class Property {

	public enum PropertyType{
		FOLDER,FILE,JDBC_URL,LOGIN,PASSWORD,LDAP_URL,SMTP_URL,IMAP_URL,POP_URL,JDBC_DRIVER
	}
	
	public PropertyType type;
	
	public String value;

	public PropertyType getType() {
		return type;
	}

	public void setType(PropertyType type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
