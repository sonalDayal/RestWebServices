package spring.restful.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import spring.restful.model.CountryBean;
import spring.restful.model.ProductDetails;

import com.google.gson.Gson;

public class JSONFileReader {

	public static void main(String[] args) throws Exception {
		
		ProductDetails cb = new ProductDetails();
		
		cb = (ProductDetails) UtilityFilePathReader.readJSONFilefromPath("ProductDetailJSON",ProductDetails.class);
		
		/*cb.setCountryName("I00nhhdia2");
		cb.setPopulation(8564523);
		cb.setState("Karnija000taka");*/
		
	
		
		try {
			File file = new File("C:/Users/477047/Desktop/saveFiles/CountryJSONFile.json");
		
			if(!file.exists()){
    			file.createNewFile();
    		}
			
			Gson gson = new Gson();

			String json = gson.toJson(cb);
			
			FileWriter fileWriter = new FileWriter(file,true);
			fileWriter.write(json);
			fileWriter.close();
			System.out.println("Writing JSON object to file");
			System.out.println("-----------------------");
			System.out.print(cb);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
