package spring.restful.dao;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;







import spring.restful.model.ProductDetails;
import spring.restful.utility.UtilityFilePathReader;


public class GetProductDetailsDAO {
	
	
	Map<String, ProductDetails> products = new HashMap<String, ProductDetails>();
	
	
	public GetProductDetailsDAO() throws FileNotFoundException
	{

		try {
			
			ProductDetails cb = new ProductDetails();
			System.out.println("hi");
			products = (Map<String, ProductDetails>) UtilityFilePathReader.readJSONFilefromPath("ProductDetailJSON",ProductDetails.class);
			System.out.println(products.size());
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public Map<String, ProductDetails> getProductDetails()
	{
		System.out.println("hi inside getproductdetails");
	/*	ProductDetails pr=new ProductDetails();
		pr=products.get(itemcode);
		System.out.println(pr.getDescription());*/
		return products;
		
	}
	
}
