package eu.malservet;

import java.io.File;
import java.net.URL;

/**
 * class to check a requirement of type folder
 * @author nicol
 *
 */
public class FileRequirement extends Requirement {

	@Override
	public boolean check() {
		boolean result = false;
		//check if the folder path is accessible
		//optional : check rights on this path
		for (Property property : properties) {
			if(property.type==Property.PropertyType.FILE){
				URL url = this.getClass().getResource(property.value);
				if(url!=null){
					new File(url.getPath());
					result = true;
				}
			}
		}
		return result;
	}

}
