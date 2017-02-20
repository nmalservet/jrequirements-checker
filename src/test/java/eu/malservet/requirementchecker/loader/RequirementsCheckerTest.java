package eu.malservet.requirementchecker.loader;

import java.util.ArrayList;
import java.util.List;

import eu.malservet.requirementschecker.loader.Requirement;
import eu.malservet.requirementschecker.loader.RequirementsChecker;
import eu.malservet.requirementschecker.ouput.Result;
import eu.malservet.requirementschecker.requirements.FileRequirement;
import junit.framework.TestCase;

public class RequirementsCheckerTest extends TestCase {

	public void testCheck() {
		RequirementsChecker r = new RequirementsChecker();
		assertNotNull(r.check(null));
		List<Requirement> requirements = new ArrayList<Requirement>();
		assertNotNull(r.check(requirements));
		requirements.add(new FileRequirement("file1", "manisfest.mf"));
		List<Result> result = r.check(requirements);
		assertNotNull(result);
		assertTrue(result.size() == 1);
		
	}

}
