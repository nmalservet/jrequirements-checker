package eu.malservet;

import eu.malservet.requirementschecker.FolderRequirement;
import junit.framework.TestCase;

/**
 * test class for folder requirement.
 * @author nicolas malservet
 *
 */
public class FolderRequirementTest extends TestCase{
	
	/**
	 * test if the check method works as expected
	 */
	public final void testCheck(){
		//folder not in the classpath ust be not found
		FolderRequirement fr = new FolderRequirement("fr1","grabouillon/");
		assertFalse(fr.check());
		//folder in the classpath
		FolderRequirement fr2 = new FolderRequirement("fr2","eu/malservet/");
		assertTrue(fr2.check());
		//check if a folder exists on the filesystem
		FolderRequirement fr3 = new FolderRequirement("fr3","/home/nicolas/netbeans-8.2/bin/");
		assertTrue("folder on filesystem cannot be found",fr3.check());
	}

}
