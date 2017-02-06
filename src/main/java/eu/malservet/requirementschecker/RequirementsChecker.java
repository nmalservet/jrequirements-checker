package eu.malservet.requirementschecker;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * main class. Check requirements described into your requirements file.<br>
 * the requirements file must be a name like requirements.xml
 * 
 * @author nicolas malservet
 *
 */
public class RequirementsChecker {

	public List<Result> check(List<Requirement> requirements) {
		List<Result> result = new ArrayList<Result>();
		if (requirements != null) {
			for (Requirement requirement : requirements) {
				switch (requirement.type) {
				case FOLDER:
					if (requirement.check()) {
						// add a result line ok
						result.add(new Result(true, "folder is accessible", requirement));
					} else {
						result.add(new Result(false, "folder is inaccesible", requirement));
					}
					break;
				case FILE:
					if (requirement.check()) {
						System.out.println("check ?");
						result.add(new Result(true, "file is accessible", requirement));
					} else {
						System.out.println("not check ?");
						result.add(new Result(false, "folder is inaccesible", requirement));
					}
					break;
				case JDBCCONNECTION:
					if (requirement.check()) {
						result.add(new Result(true, "jdbc connection is reacheable", requirement));
					} else {
						result.add(new Result(false, "jdbc connection is unreacheable", requirement));
					}
					break;
				default:
					break;
				}
			}
		}
		return result;
	}

	public String resultToXML() {
		return null;
	}

	public String resultToJSON() {
		return null;
	}

	public String resultToHTML() {
		return null;
	}

	/**
	 * print the result into the specified fileName
	 * 
	 * @param result
	 * @param fileName
	 */
	public void printToFile(String result, String fileName) {
		File file = new File(fileName);
		System.out.println("TODO implement print to file"+file.getAbsolutePath());

	}

	/**
	 * print the result into the default fileName.
	 * 
	 * @param result
	 */
	public void printToFile(String result) {
		printToFile(result, "result.xml");
	}
}
