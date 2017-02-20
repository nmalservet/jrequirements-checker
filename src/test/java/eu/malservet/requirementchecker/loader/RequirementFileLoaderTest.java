package eu.malservet.requirementchecker.loader;

import java.io.FileNotFoundException;

import eu.malservet.requirementschecker.loader.RequirementsFileLoader;
import junit.framework.TestCase;

/**
 * test class for @see eu.malservet.requirementchecker.loader.RequirementFileLoader
 * @author nicolas malservet
 *
 */
public class RequirementFileLoaderTest extends TestCase{
	
	public final void testLoad(){
		RequirementsFileLoader rf = new RequirementsFileLoader();
		try {
			rf.load();
		} catch (FileNotFoundException e) {
			fail("File Not found in the classpath"+e.getMessage());
		}
		try {
			rf.load("");
		} catch (FileNotFoundException e) {
			fail("File Not found in the classpath"+e.getMessage());
		}
	}

}
