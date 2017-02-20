package eu.malservet.requirementschecker;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * class to check a requirement of type file
 * 
 * @author nicolas malservet
 *
 */
public class FileRequirement extends Requirement {

	public FileRequirement(String name, String value) {
		super(name, Requirement.RequirementType.FILE, value);
	}

	/**
	 * check if the requirement of type file is accessible. the value can be an
	 * absolute or relative path. TODO maage absolute path
	 */
	@Override
	public boolean check() {
		boolean result = false;
		URL url = this.getClass().getClassLoader().getResource(this.value);
		if (url != null) {
			// TODO use resourseastream instead of File
			File f = new File(url.getPath());
			if (f.exists() && f.isFile())
				result = true;
		} else {
			// try to get the file from an absolute path
			try {
				URL url2 = new URL("file://" + this.value);
				if (url2 != null) {
					// TODO use resourseastream instead of File
					File f = new File(url2.getPath());
					if (f.exists() && f.isFile())
						result = true;
				}
			} catch (MalformedURLException e) {
				System.out.println("malformed url:" + e.getMessage());
			}

		}
		// check if the folder path is accessible
		// optional : check rights on this path
		return result;
	}

}
