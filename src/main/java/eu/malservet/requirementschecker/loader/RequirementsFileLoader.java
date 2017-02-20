package eu.malservet.requirementschecker;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * class to import properties. Properties files can be XML file, JSON file, Yaml
 * file
 * 
 * @author nicolas malservet
 *
 */
public class RequirementsFileLoader {

	/**
	 * load a file into resources.
	 */
	public File load(String directory) {
		URL url = this.getClass().getClassLoader().getResource(directory + "requirements.xml");
		if (url != null) {
			return new File(url.getPath());
		} else {
			return null;
		}
	}

	/**
	 * load a file from classpath
	 */
	public File load() {
		return this.load("");
	}

	public List<Requirement> build(File file) {
		List<Requirement> result = new ArrayList<Requirement>();
		return result;
	}
}
