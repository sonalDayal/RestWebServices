package spring.restful.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import spring.restful.model.ProductDetails;


import com.google.gson.Gson;

public class JSONFileWriter {

	public static void main(String[] args) {
		
		ProductDetails productDetails = new ProductDetails();
		
		//cb = (CountryBean) UtilityFilePathReader.readJSONFilefromPath("JSONSimpleWritingToFileExample",CountryBean.class);
		
		productDetails.setDescription("d2");
		productDetails.setDiscount(0);
		productDetails.setItemcode("#1235");
		productDetails.setItemprice(2344.6f);
		productDetails.setMRP(2334.6f);
		productDetails.setQuantity(3);
		try {
			File file = new File("C:/Users/477047/Desktop/saveFiles/ProductJSONFile.json");
		
			if(!file.exists()){
    			file.createNewFile();
    		}
			
			Gson gson = new Gson();

			String json = gson.toJson(productDetails);
			
			FileWriter fileWriter = new FileWriter(file,true);
			fileWriter.write(json);
			fileWriter.close();
			System.out.println("Writing JSON object to file");
			System.out.println("-----------------------");
			System.out.print(productDetails);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
