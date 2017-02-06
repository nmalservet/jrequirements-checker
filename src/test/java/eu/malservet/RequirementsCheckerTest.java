package eu.malservet;

import java.util.ArrayList;
import java.util.List;

import eu.malservet.requirementschecker.FileRequirement;
import eu.malservet.requirementschecker.Requirement;
import eu.malservet.requirementschecker.RequirementsChecker;
import eu.malservet.requirementschecker.Result;
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
