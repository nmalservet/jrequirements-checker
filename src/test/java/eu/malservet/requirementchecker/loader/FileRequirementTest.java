package eu.malservet.requirementchecker.loader;

import java.io.File;
import java.io.IOException;

import eu.malservet.requirementschecker.requirements.FileRequirement;
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
		File f =  new File("test.txt");
		try {
			assertTrue("file cannot be created",f.createNewFile());
		} catch (IOException e) {
			fail(e.getMessage());
		}
		String path = f.getAbsolutePath();
		FileRequirement fr3 = new FileRequirement("fr3",path);
		assertTrue("file on filesystem cannot ben found:"+path,fr3.check());
		f.delete();
		assertFalse("file on filesystem can be found, but is deleteds:"+path,fr3.check());
	}

}
