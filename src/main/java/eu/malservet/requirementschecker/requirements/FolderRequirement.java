package eu.malservet.requirementschecker;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * class to check a requirement of type folder
 * @author nicolas malservet
 *
 */
public class FolderRequirement extends Requirement {
	
	public FolderRequirement(String name, String value) {
		super(name, Requirement.RequirementType.FOLDER, value);
	}

	/**
	 * check if the requirement of type file is accessible. the value can be an
	 * absolute or relative path.
	 */
	@Override
	public boolean check() {
		boolean result = false;
		URL url = this.getClass().getClassLoader().getResource(this.value);
		if (url != null) {
			// TODO use resourseastream instead of File
			File f = new File(url.getPath());
			//TODO check javadoc, pb wih dir
			if (f.exists() && f.isDirectory() && f.canRead())
				result = true;
		} else {
			// try to get the file from an absolute path
			try {
				URL url2 = new URL("file://" + this.value);
				if (url2 != null) {
					// TODO use resourseastream instead of File
					File f = new File(url2.getPath());
					if (f.exists() && f.isDirectory())
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
