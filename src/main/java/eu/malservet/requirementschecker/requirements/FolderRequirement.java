package eu.malservet.requirementschecker.requirements;

import java.io.File;
import java.io.InputStream;

import eu.malservet.requirementschecker.loader.Requirement;

/**
 * class to check a requirement of type folder
 * 
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
		/*
		 * URL url = this.getClass().getClassLoader().getResource(this.value);
		 * 
		 * if (url != null) { System.out.println("url:" + url.getPath()); //
		 * TODO use resourseastream instead of File File f = new
		 * File(url.getPath()); // TODO check javadoc, pb wih dir if (f.exists()
		 * && f.isDirectory() && f.canRead()) { result = true; } }else{ //check
		 * if it is an absolute path // }
		 */
		// Path path =
		InputStream s = FolderRequirement.class.getResourceAsStream(this.value);

		// Path path = FileSystems.getDefault().getPath(this.value);
		// System.out.print("ici:" + path.toString());
		File f = new File(this.value);
		if (f.exists() && f.isDirectory())
			result = true;

		// check if the folder path is accessible
		// optional : check rights on this path
		return result;
	}

}
