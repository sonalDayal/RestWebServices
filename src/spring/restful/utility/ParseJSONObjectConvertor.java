package spring.restful.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spring.restful.model.ProductDetails;

import com.google.gson.Gson;

/**
 */
public class ParseJSONObjectConvertor {

	static Gson gson;
	static {
		gson = getInstance();
	}

	/**
	 * Method getParsedObjectFromString.
	 * 
	 * @param toParse
	 *            String
	 * @param classOfT
	 *            Class<?>
	 * @return Object
	 */
	public static Object getParsedObjectFromString(String toParse,
			Class<?> classOfT) {
		Object convertedObject = null;
		try {
			convertedObject = gson.fromJson(toParse, classOfT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return convertedObject;
	}

	/**
	 * Method getInstance.
	 * 
	 * @return Gson
	 */
	private static Gson getInstance() {
		// TODO Auto-generated method stub
		return new Gson();
	}

	/**
	 * Method getParsedObjectFromFile.
	 * 
	 * @param file
	 *            File
	 * @param classOfT
	 *            Class<?>
	 * @return Object
	 */
	public static Object getParsedObjectFromFile(File file, Class<?> classOfT) {
		Map<String, ProductDetails> convertedObject = null;
		convertedObject=readFile(file,classOfT);
		
		return convertedObject;
	}

	/**
	 * Method readFile.
	 * 
	 * @param readFile
	 *            File
	 * @param classOfT 
	 * @return String
	 */
	@SuppressWarnings("resource")
	static Map<String, ProductDetails> readFile(File readFile, Class<?> classOfT) {
		StringBuilder sb = new StringBuilder();
		BufferedReader br;
		Object convertedObject=null;
		List<Object> convertedObjectList=new ArrayList<Object>();
		Map<String, ProductDetails> products = new HashMap<String, ProductDetails>();
		ProductDetails productDetails=new ProductDetails();
		try {
			br = new BufferedReader(new FileReader(readFile));
			try {
				String line = br.readLine();
				while (line != null) {
					sb= new StringBuilder();
					System.out.println("line"+line);
					sb.append(line);
					sb.append("\n");
					line = br.readLine();
					System.out.println("line after br.readLine"+line);
					System.out.println("sb . to string"+sb.toString());
					convertedObject = gson.fromJson(sb.toString(), classOfT);
					System.out.println("convertedObject"+convertedObject);
					productDetails=(ProductDetails) convertedObject;
					System.out.println("convertedObject"+convertedObject);
					convertedObjectList.add(productDetails);
					products.put(productDetails.getItemcode(), productDetails);
					System.out.println("convertedObjectList"+convertedObjectList.size());
				}
			} finally {
				br.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return products;
	}

	/**
	 * Method getJson.
	 * 
	 * @param obj
	 *            Object
	 * @return String
	 */
	static String getJson(Object obj) {
		return gson.toJson(obj);
	}

	

	/**
	 * Method main.
	 * 
	 * @param args
	 *            String[]
	 */
	
}
