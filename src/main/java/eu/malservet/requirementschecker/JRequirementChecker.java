package eu.malservet.requirementschecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import eu.malservet.requirementschecker.loader.Requirement;
import eu.malservet.requirementschecker.loader.RequirementsChecker;
import eu.malservet.requirementschecker.loader.RequirementsFileLoader;
import eu.malservet.requirementschecker.ouput.Result;

/**
 * main class. Check requirements described into your requirements file.<br>
 * the requirements file must be a name like requirements.xml
 * 
 * @author nicolas malservet
 *
 */
public class JRequirementChecker {
	/**
	 * TODO launch it in a command line
	 * main method. launch teh checker.
	 */
	public static void main(){
		//load the requirements file
		RequirementsFileLoader rfl = new RequirementsFileLoader();
		File file;
		try {
			file = rfl.load();
			//build the current checker
			List<Requirement> requirements = rfl.build(file);
			//check each dependency
			RequirementsChecker rc = new RequirementsChecker();
			List<Result> results = rc.check(requirements);
			//print the results	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
