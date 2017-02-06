package eu.malservet;

import eu.malservet.requirementschecker.FileRequirement;
import junit.framework.TestCase;

/**
 * test class for file requirement.
 * @author nicolas malservet
 *
 */
public class FileRequirementTest extends TestCase{
	
	/**
	 * test if the check method works as expected
	 */
	public final void testCheck(){
		//file not in the classpath ust be not found
		FileRequirement fr = new FileRequirement("fr1","manifest2.mf");
		assertFalse(fr.check());
		//file in the classpath
		FileRequirement fr2 = new FileRequirement("fr2","readme.md");
		assertTrue(fr2.check());
		//check if a file exists on the filesystem
		FileRequirement fr3 = new FileRequirement("fr3","/home/nicolas/netbeans-8.2/bin/netbeans");
		assertTrue("file on filesystem cannot ben found",fr3.check());
	}

}
