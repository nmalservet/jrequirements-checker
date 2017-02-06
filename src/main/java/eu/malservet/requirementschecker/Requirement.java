package eu.malservet.requirementschecker;

import java.util.ArrayList;
import java.util.List;

/**
 * a requirement is somethin to be checked.
 * @author nicolas malservet
 *
 */
public abstract class Requirement {

	public enum RequirementType{
		FOLDER,FILE,JDBCCONNECTION,SMTP,POP,IMAP,LDAP,JAVAVERSION
	}
	
	public Requirement(String name, RequirementType type,String value){
		this.name = name;
		this.type = type;
		this.value = value;
	}
	
	public Requirement(){
		this.properties = new ArrayList<Property>();
	}
	/**
	 * type of the requirement.
	 */
	public Requirement.RequirementType type;
	
	/**
	 * name of the requirement
	 */
	public String name;
	
	/**
	 * the value to be checked. If the value checked is true, then the requirement is ok.
	 */
	public String value;
	/**
	 * list of the properties
	 */
	public List<Property> properties;
	
	/**
	 * add a property, each subclass need to define his own behavior.
	 * @param property
	 */
	public void addProperty(Property property){
		this.properties.add(property);
	}
	/**
	 * method that check is the requirement is provided.
	 * @return
	 */
	public abstract boolean check();
}
