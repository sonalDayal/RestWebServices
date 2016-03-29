package spring.restful.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;



/**
 */
public final class UtilityFilePathReader {

	public UtilityFilePathReader() {
	}
	

	static final String filePath ="\\spring\\restful\\utility\\";
	static final String propertiesPath = filePath+"LoadUtilitiesReader.properties";
	static Properties prop = new Properties();
	static InputStream input = null;
	

	/**
	 * Method getUtilProperties.
	 * 
	 * @param loadProp
	 *            String
	 * @return String
	 */
	public static String getUtilProperties(String loadProp) {
		try {
			// ClassLoader loader =
			// Thread.currentThread().getContextClassLoader();
			// org.apache.commons.io.FileUtils.toFile(UtilityFilePathReader.class.getResource(propertiesPath));
			
			//UtilityFilePathReader.input = new FileInputStream(UtilityFilePathReader.propertiesPath);
			// input =
			// UtilityFilePathReader.class.getResourceAsStream(propertiesPath);
			// load a properties file
			// prop.load(input);
			//UtilityFilePathReader.prop.load(UtilityFilePathReader.input);
			UtilityFilePathReader.prop.load(UtilityFilePathReader.class.getResourceAsStream("\\LoadUtilitiesReader.properties"));
			System.out.println(UtilityFilePathReader.prop.getProperty(loadProp));
			return UtilityFilePathReader.prop.getProperty(loadProp);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (UtilityFilePathReader.input != null) {
				try {
					UtilityFilePathReader.input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	static UtilityFilePathReader utilityFileReader;

	/**
	 * Returns instance of UtilityFilePathReader
	 * 
	 * @return utilityFileReader * @throws Exception
	 */
	public static synchronized UtilityFilePathReader getInstance()
			throws Exception {
		if (UtilityFilePathReader.utilityFileReader == null) {
			UtilityFilePathReader.utilityFileReader = new UtilityFilePathReader();
		}
		return UtilityFilePathReader.utilityFileReader;
	}

	/**
	 * Method readJSONFilefromPath.
	 * 
	 * @param loadProp
	 *            String
	 * @param classType
	 *            Class<?>
	 * @return Object
	 */
	public static Object readJSONFilefromPath(String loadProp,
			Class<?> classType) throws Exception {
		 final DefaultResourceLoader loader = new DefaultResourceLoader();
		    Resource resource = loader.getResource("spring/restful/utility/ProductJSONFile.json");
		    File readFile = resource.getFile();
		//File readFile = new File("spring/restful/utility/ProductJSONFile.json");
		return ParseJSONObjectConvertor.getParsedObjectFromFile(readFile,
				classType);
	}

	
}
