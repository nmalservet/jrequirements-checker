package eu.malservet.requirementchecker.loader;

import eu.malservet.requirementschecker.requirements.FolderRequirement;
import junit.framework.TestCase;

/**
 * test class for folder requirement.
 * 
 * @author nicolas malservet
 *
 */
public class FolderRequirementTest extends TestCase {

	/**
	 * test if the check method works as expected :<br>
	 * folder existing in the classpath<br>
	 * folder inexisting in the classpath<br>
	 * folder existing out the classpath<br>
	 * folder inexisting out the classpath<br>
	 */
	public final void testCheck() {
		// folder not in the classpath ust be not found
		FolderRequirement fr = new FolderRequirement("fr1", "grabouillon/");
		assertFalse("folder inexisting can be found!", fr.check());
		// folder in the classpath
		FolderRequirement fr2 = new FolderRequirement("fr2", "src/main");
		assertTrue(fr2.check());
		// check if a folder exists on the filesystem
		FolderRequirement fr3 = new FolderRequirement("fr3", "/var/");
		assertTrue("folder on filesystem cannot be found", fr3.check());
	}

}
