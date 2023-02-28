package tek.capstone.bdd.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.yaml.snakeyaml.Yaml;

public class ReadYamlFiles {
	
	private static ReadYamlFiles readYmlFiles;
	private HashMap propertyMap;
	
	private ReadYamlFiles(String filePath) throws FileNotFoundException {
		FileInputStream fileInputStream = FileUtility.getFileInputStream(filePath);
		Yaml yml = new Yaml();
		this.propertyMap  = yml.load(fileInputStream);
		
	}
	
	public HashMap getYamlProperty(String key) {
		return (HashMap)this.propertyMap.get(key);
	}
	
	public static ReadYamlFiles getInstance(String filePath) throws FileNotFoundException {
		if(readYmlFiles == null) {
			return new ReadYamlFiles(filePath);
		}
		return readYmlFiles;
	}
	
	
}
